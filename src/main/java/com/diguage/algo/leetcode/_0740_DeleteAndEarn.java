package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0740_DeleteAndEarn {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 15:23:34
   */
  public int deleteAndEarn(int[] nums) {
    int max = Arrays.stream(nums).max().getAsInt();
    int[] sum = new int[max + 1];
    for (int num : nums) {
      sum[num] += num;
    }
    int a = sum[0];
    // 只有头两个元素时，那个元素点数多。
    // TODO 这里有个疑问：加入有 3✖1，,2✖2，
    //  3✖1<2✖2，取完2后，还有一个 1，就不要了吗？
    // 理解错了：选择某个点数后，必须删除“所有”相邻的数字
    int b = Math.max(sum[0], sum[1]);
    for (int i = 2; i < sum.length; i++) {
      int tmp = b;
      // dp[i] = max(array[i] + dp[i-2], dp[i-1])
      b = Math.max(sum[i] + a, b);
      a = tmp;
    }
    return b;
  }
  // end::answer[]
}
