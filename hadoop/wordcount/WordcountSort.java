import java.io.IOException;

import java.util.Random;

import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.io.WritableComparable;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;

import org.apache.hadoop.mapreduce.lib.map.InverseMapper;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import org.apache.hadoop.util.GenericOptionsParser;

public class WordcountSort {

	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

		private final static IntWritable one = new IntWritable(1);

		private Text word = new Text();

		private String pattern = "[^//w]"; //0-9, a-z, A-Z

		public void map(Object key, Text value, Context context)

				throws IOException, InterruptedException {

			StringTokenizer itr = new StringTokenizer(value.toString(), ",");

			while (itr.hasMoreTokens()) {
				String tmp = itr.nextToken();
				if(tmp.charAt(0) - '0' >= 0 && tmp.charAt(0) - '0' <= 9) continue;
        String tmp2 = "a" + tmp;
				word.set(tmp2);

				context.write(word, one);

			}

		}

	}

	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values,

				Context context) throws IOException, InterruptedException {

			int sum = 0;

			for (IntWritable val : values) {

				sum += val.get();

			}

			result.set(sum);

			context.write(key, result);

		}

	}

	private static class IntWritableDecreasingComparator extends IntWritable.Comparator {

		public int compare(WritableComparable a, WritableComparable b) {

			return -super.compare(a, b);

		}

		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {

			return -super.compare(b1, s1, l1, b2, s2, l2);

		}

	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();

		String[] otherArgs = new GenericOptionsParser(conf, args)

				.getRemainingArgs();

		if (otherArgs.length != 2) {

			System.err.println("Usage: wordcount <in> <out>");

			System.exit(2);

		}

		Path tempDir = new Path("wordcount-temp-" + Integer.toString(

				new Random().nextInt(Integer.MAX_VALUE))); //

		Job job = new Job(conf, "word count");

		job.setJarByClass(WordcountSort.class);

		try {

			job.setMapperClass(TokenizerMapper.class);

			job.setCombinerClass(IntSumReducer.class);

			job.setReducerClass(IntSumReducer.class);

			job.setOutputKeyClass(Text.class);

			job.setOutputValueClass(IntWritable.class);

			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));

			FileOutputFormat.setOutputPath(job, tempDir);//

			job.setOutputFormatClass(SequenceFileOutputFormat.class);

			if (job.waitForCompletion(true))

			{

				Job sortJob = new Job(conf, "sort");

				sortJob.setJarByClass(WordcountSort.class);

				FileInputFormat.addInputPath(sortJob, tempDir);

				sortJob.setInputFormatClass(SequenceFileInputFormat.class);

				sortJob.setMapperClass(InverseMapper.class);

				sortJob.setNumReduceTasks(1);

				FileOutputFormat.setOutputPath(sortJob, new Path(otherArgs[1]));

				sortJob.setOutputKeyClass(IntWritable.class);

				sortJob.setOutputValueClass(Text.class);

				sortJob.setSortComparatorClass(IntWritableDecreasingComparator.class);

				System.exit(sortJob.waitForCompletion(true) ? 0 : 1);

			}

		} finally {

			FileSystem.get(conf).deleteOnExit(tempDir);

		}

	}

}
