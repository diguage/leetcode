package com.diguage.algo.leetcode;

public class _0287_FindTheDuplicateNumber_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-17 21:53:03
   */
  public int findDuplicate(int[] nums) {
    // 利用快慢指针判断链表是否有环的思路，找到快慢指针的汇合点
    int slow = 0, fast = 0;
    do {
      slow = nums[slow];
      fast = nums[fast];
      fast = nums[fast];
    } while (slow != fast);

    // 从链表头开始遍历，直到相遇，则就是重复元素
    fast = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  // end::answer[]
  static void main() {
    new _0287_FindTheDuplicateNumber_3()
      .findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
  }
}
