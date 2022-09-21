# pip install tweepy
# pip install pandas
# pip install snscrape

import tweepy
import snscrape.modules.twitter as sntwitter
import pandas as pd
import mecab_ko as MeCab

tagger = MeCab.Tagger()
# print(type(tagger.parse("아버지가방에들어가신다")))
print(tagger.parse("아버지가방에들어가신다"))
# print(tagger.parse("아버지가방에들어가신다").split()[1].split(",")[0])
# print(len(tagger.parse("아버지가방에들어가신다").split()))
print(tagger.parse("아버지가방에들어가신다").split()[12])

# 발급받은 키 입력
twitter_consumer_key = "7JUcMFJpKejaAy4VRwB4MHaIh"
twitter_consumer_secret = "FAOg16Rz3WWxvqrdFkZbaWgcAyGaGB1s4BWEgYWY1IoBfEhaR1"
twitter_access_token = "1569900011550568448-blsCGbNKpKMYgj6uLhoL8o99SycQ1z"
twitter_access_secret = "NzAkQn2B7fLxXiAf5hYnWnhI4XmSBv28W0ukHxRu0I1Tv"

# class MyStreamListener(tweepy.StreamListener):
#
#     def on_status(self, status):
#         print(status.text)

auth = tweepy.OAuthHandler(twitter_consumer_key, twitter_consumer_secret)
auth.set_access_token(twitter_access_token, twitter_access_secret)
api = tweepy.API(auth)

tweets = []
limit = 100

query = ["건강식품 since:2022-09-19"]
for tweet in sntwitter.TwitterSearchScraper(query).get_items():
  if len(tweets) == limit:
    break
  else:
    # tweets.append([tweet.date, tweet.username, tagger.parse(tweet.content).split()])
    tweets.append([tagger.parse(tweet.content).split()])
  # tweets.append([tweet.date, tweet.username, tweet.content])

# df = pd.DataFrame(tweets, columns=['Data', 'User', 'Tweet'])
df = pd.DataFrame(tweets)
df.to_csv('cold_today2.csv')
# print(df)
