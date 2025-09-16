package com.diguage.algo.leetcode;

import java.util.*;

public class _0355_DesignTwitter_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-16 21:05:24
   */
  static class Twitter {

    private Map<Integer, Set<Integer>> follower;
    private Map<Integer, Tweet> tweets;

    private int timestamp;


    public Twitter() {
      follower = new HashMap<>();
      tweets = new HashMap<>();
      timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
      timestamp++;
      Tweet tweet = new Tweet(tweetId, timestamp);
      tweet.next = tweets.get(userId);
      tweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
      PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) ->
        Integer.compare(b.timestamp, a.timestamp));
      if (tweets.containsKey(userId)) {
        queue.offer(tweets.get(userId));
      }
      Set<Integer> followers = follower.getOrDefault(userId, new HashSet<>());
      for (Integer uid : followers) {
        if (tweets.containsKey(uid)) {
          queue.offer(tweets.get(uid));
        }
      }
      List<Integer> result = new ArrayList<>();
      while (!queue.isEmpty() && result.size() < 10) {
        Tweet ts = queue.poll();
        result.add(ts.tweetId);
        if (ts.next != null) {
          queue.offer(ts.next);
        }
      }
      return result;
    }

    public void follow(int followerId, int followeeId) {
      if (followeeId == followerId) {
        return;
      }
      follower.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
      if (followeeId == followerId) {
        return;
      }
      follower.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }

    private static class Tweet {
      int tweetId;
      int timestamp;
      Tweet next;

      public Tweet(int tweetId,int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
      }
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 4);
    twitter.postTweet(2, 5);
    twitter.unfollow(1, 2);
    twitter.follow(1, 2);
    twitter.getNewsFeed(1);
  }
}
