package com.diguage.algo.leetcode;

public class _1997_FirstDayWhereYouHaveBeenInAllTheRooms {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-22 20:19:06
   */
  public int firstDayBeenInAllRooms(int[] nextVisit) {
    int mod = (int) 1e9 + 7;
    int len = nextVisit.length;
    int[] dp = new int[len];
    dp[0] = 2;
    for (int i = 1; i < len; i++) {
      int to = nextVisit[i];
      dp[i] = dp[i - 1] + 2;
      if (to != 0) {
        dp[i] = (dp[i] - dp[to - 1] + mod) % mod;
      }
      dp[i] = (dp[i] + dp[i - 1]) % mod;
    }
    return dp[len - 2];
  }
  // end::answer[]
  public static void main(String[] args) {
    int day = new _1997_FirstDayWhereYouHaveBeenInAllTheRooms()
      .firstDayBeenInAllRooms(new int[]{0, 0, 2});
    System.out.println(day);
  }
}
