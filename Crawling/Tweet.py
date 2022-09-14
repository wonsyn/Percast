pip install tweepy
pip install pandas
pip install snscrape

import tweepy
import snscrape.modules.twitter as sntwitter
import pandas as pd

# 발급받은 키 입력
twitter_consumer_key = ""
twitter_consumer_secret = ""
twitter_access_token = ""
twitter_access_secret = ""

class MyStreamListener(tweepy.StreamListener):

    def on_status(self, status):
        print(status.text)

auth = tweepy.OAuthHandler(twitter_consumer_key, twitter_consumer_secret)
auth.set_access_token(twitter_access_token, twitter_access_secret)
api = tweepy.API(auth)

tweets = []
# limit = 5000

query = ["감기 until:2022-01-01 since:2021-12-01"]
for tweet in sntwitter.TwitterSearchScraper(query).get_items():
  # print(tweet)
  # break
  # if len(tweets) == limit:
  #   break
  # else:
  #   tweets.append([tweet.date, tweet.username, tweet.content])
  tweets.append([tweet.date, tweet.username, tweet.content])

df = pd.DataFrame(tweets, columns=['Data', 'User', 'Tweet'])
print(df)