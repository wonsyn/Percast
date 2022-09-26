import tweepy
import snscrape.modules.twitter as sntwitter
import pandas as pd
import mecab_ko as MeCab
from datetime import date, timedelta
from sqlalchemy import create_engine
import pymysql

db_connection_str = 'mysql+pymysql://percast:ssafy7@3.34.43.90:3306/percast?charset=utf8'
db_connection = create_engine(db_connection_str, encoding='utf-8')
conn = db_connection.connect()

today = date.today()
yesterday = date.today() - timedelta(days=14)

tagger = MeCab.Tagger()

# 발급받은 키 입력
twitter_consumer_key = "7JUcMFJpKejaAy4VRwB4MHaIh"
twitter_consumer_secret = "FAOg16Rz3WWxvqrdFkZbaWgcAyGaGB1s4BWEgYWY1IoBfEhaR1"
twitter_access_token = "1569900011550568448-blsCGbNKpKMYgj6uLhoL8o99SycQ1z"
twitter_access_secret = "NzAkQn2B7fLxXiAf5hYnWnhI4XmSBv28W0ukHxRu0I1Tv"

auth = tweepy.OAuthHandler(twitter_consumer_key, twitter_consumer_secret)
auth.set_access_token(twitter_access_token, twitter_access_secret)
api = tweepy.API(auth)

tweets = []
# limit = 100
str = "눈병 since:" + yesterday.strftime('%Y-%m-%d')

# query = ["감기 since:2022-09-19"]
query = str
if query != 0:
  for tweet in sntwitter.TwitterSearchScraper(query).get_items():
    tmp = tagger.parse(tweet.content).split()
    for i in range(1, len(tmp), 2):
      ttmp = tmp[i].split(",")
      if ttmp[0].startswith('NNG') or ttmp[0].startswith('NNP'):
        tweets.append(ttmp[3])
# df = pd.DataFrame(tweets, columns=['Data', 'User', 'Tweet'])
df = pd.DataFrame(tweets, columns=['word'])
df.to_csv('eye_disease_today.csv')
df.to_sql(name='eye_disease_input', con=db_connection, if_exists='replace', index=False)