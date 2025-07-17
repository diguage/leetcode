package com.diguage.algo.leetcode;

import java.util.*;

public class _0355_DesignTwitter {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-17 22:34:01
   */
  class Twitter {

    // 关注列表
    Map<Integer, Set<Integer>> follower;
    // 被谁关注
    Map<Integer, Set<Integer>> followee;

    List<Tweet> tweets;
    Map<Integer, Integer> count;

    public Twitter() {
      follower = new HashMap<>();
      followee = new HashMap<>();
      tweets = new ArrayList<>();
      count = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
      tweets.add(new Tweet(userId, tweetId));
      Integer oriCnt = count.getOrDefault(userId, 0);
      if (oriCnt >= 10) {
        for (int i = 0; i < tweets.size(); i++) {
          Tweet tweet = tweets.get(i);
          if (tweet.owner == userId) {
            tweets.remove(i);
            break;
          }
        }
      } else {
        int cnt = oriCnt + 1;
        count.put(userId, cnt);
      }
    }

    public List<Integer> getNewsFeed(int userId) {
      List<Integer> result = new ArrayList<>();
      for (int i = tweets.size() - 1; i >= 0; i--) {
        Tweet tweet = tweets.get(i);
        if (tweet.owner == userId
          || follower.getOrDefault(userId, Collections.emptySet()).contains(tweet.owner)) {
          result.add(tweet.tweet);
        }
        if (result.size() == 10) {
          break;
        }
      }
      return result;
    }

    public void follow(int followerId, int followeeId) {
      if (followerId == followeeId) {
        return;
      }
      follower.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
      followee.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
      if (followerId == followeeId) {
        return;
      }
      Set<Integer> followers = follower.get(followerId);
      if (followers != null) {
        followers.remove(followeeId);
      }
      Set<Integer> followees = followee.get(followeeId);
      if (followees != null) {
        followees.remove(followerId);
      }
    }

    private static class Tweet {
      int owner;
      int tweet;

      public Tweet(int owner, int tweet) {
        this.owner = owner;
        this.tweet = tweet;
      }
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    Twitter twitter = new _0355_DesignTwitter().new Twitter();
    twitter.postTweet(1, 5);
    twitter.getNewsFeed(1);
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    twitter.getNewsFeed(1);
    twitter.unfollow(1, 2);
    twitter.getNewsFeed(1);
  }
}
