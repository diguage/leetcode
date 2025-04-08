package com.diguage.algo.leetcode;

public class _0474_OnesAndZeroes_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-08 20:44:04
   */
  public int findMaxForm(String[] strs, int m, int n) {
    // 计算每个字符串中 0 和 1 的数量
    int length = strs.length;
    int[][] bits = new int[length][2];
    for (int i = 0; i < length; i++) {
      for (char c : strs[i].toCharArray()) {
        bits[i][c - '0']++;
      }
    }
    // 1、确定 dp 数组（dp table）以及下标的含义
    //   ① 表示此时处理的字符串
    //   ② 表示此时 0 的个数，即 0 的数量限制
    //   ③ 表示此时 1 的个数，即 1 的数量限制
    // (x, y, z) 指的是到达第 x 个字符串时，
    // 如果有 y 个 0 和 z 个 1，那么最大子集数量
    // 3、dp 数组如何初始化
    //   由于不能为负数，最初都没有选择，则全部初始化为 0
    int[][][] dp = new int[length + 1][m + 1][n + 1];
    // 4、确定遍历顺序
    //   从第一个字符串开始遍历
    for (int x = 1; x <= length; x++) {
      int zeros = bits[x - 1][0];
      int ones = bits[x - 1][1];
      for (int y = 0; y <= m; y++) {
        for (int z = 0; z <= n; z++) {
          // 2、确定递推公式
          //  dp[x][y][z] = max(dp[x][y][z], dp[x-1][y - zeros][z - ones] + 1);
          if (y >= zeros && z >= ones) {
            // 在加入当前字符串和不加入当前字符串中选择其一
            dp[x][y][z] = Math.max(dp[x - 1][y][z], dp[x - 1][y - zeros][z - ones] + 1);
          } else {
            // 0 和 1 的容量不够，无法加入当前字符串，只能从上面继承
            dp[x][y][z] = dp[x - 1][y][z];
          }
        }
      }
    }
    return dp[length][m][n];
  }
  // end::answer[]
}
