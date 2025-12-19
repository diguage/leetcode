package com.diguage.algo.leetcode;

public class _2560_HouseRobberIv_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-19 20:19:07
   */
  public int minCapability(int[] nums, int k) {
    int low = Integer.MAX_VALUE, up = Integer.MIN_VALUE;
    for (int num : nums) {
      low = Math.min(low, num);
      up = Math.max(up, num);
    }
    while (low <= up) {
      int mid = low + (up - low) / 2;
      if (check(nums, mid, k)) {
        up = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private boolean check(int[] nums, int mid, int k) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= mid) {
        count++;
        i++; // 跳过下一个，隔一个再偷
      }
    }
    return count >= k;
  }

  // 深度优先遍历，超时
  //  public int minCapability(int[] nums, int k) {
  //    if (k == 1) {
  //      return Arrays.stream(nums).min().getAsInt();
  //    }
  //    int result = Integer.MAX_VALUE;
  //    for (int i = 0; nums.length - i < 2 * (k - 1) + 1; i++) {
  //      int next = dfs(nums, k, i, 0, result);
  //      if (next < 0) {
  //        continue;
  //      }
  //      result = Math.min(result, next);
  //    }
  //    return result;
  //  }
  //
  //  private int dfs(int[] nums, int k, int start,
  //                  int maxNum, int existedResult) {
  //    if (k == 0) {
  //      return maxNum;
  //    }
  //    if (k < 0) {
  //      return -1;
  //    }
  //    if (nums.length - start < 2 * (k - 1) + 1) {
  //      return -1;
  //    }
  //    for (int i = 2; i < nums.length; i++) {
  //      int next = dfs(nums, k - 1, start + i,
  //        Math.max(maxNum, nums[start]), existedResult);
  //      if (next < 0) {
  //        continue;
  //      }
  //      existedResult = Math.min(existedResult, next);
  //    }
  //    return existedResult;
  //  }
  // end::answer[]

  static void main() {
    new _2560_HouseRobberIv_2().minCapability(new int[]{2, 3, 5, 9}, 2);
  }

}
