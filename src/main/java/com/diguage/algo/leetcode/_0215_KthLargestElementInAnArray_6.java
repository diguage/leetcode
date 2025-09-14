package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-13 22:15:50
   */
  public int findKthLargest(int[] nums, int k) {
    return quickselect(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quickselect(int[] nums, int l, int r, int k) {
    if (l == r) {
      return nums[k];
    }
    int x = nums[l], i = l - 1, j = r + 1;
    while (i < j) {
      do {
        i++;
      } while (nums[i] < x);
      do {
        j--;
      } while (x < nums[j]);
      if (i < j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
      }
    }
    if (k <= j) {
      return quickselect(nums, l, j, k);
    } else {
      return quickselect(nums, j + 1, r, k);
    }
  }
//  public int findKthLargest(int[] nums, int k) {
//    if (nums.length == 1) {
//      return nums[0];
//    }
//    int index = partition(nums, 0, nums.length - 1);
//    k = nums.length - k;
//    int low = 0, high = nums.length - 1;
//    while (index != k) {
//      if (index < k) {
//        low = index + 1;
//      } else {
//        high = index - 1;
//      }
//      index = partition(nums, low, high);
//    }
//    return nums[k];
//  }

//  private int partition(int[] nums, int low, int hight) {
//    int priovt = nums[low];
//    int l = low, h = hight + 1;
//    while (true) {
//      while (nums[++l] < priovt) {
//        if (l == hight) {
//          break;
//        }
//      }
//      while (nums[--h] > priovt) {
//        if (h == low) {
//          break;
//        }
//      }
//      if (l >= h) {
//        break;
//      }
//      int temp = nums[l];
//      nums[l] = nums[h];
//      nums[h] = temp;
//    }
//    nums[low] = nums[h];
//    nums[h] = priovt;
//    return h;
//  }

  // end::answer[]
  public static void main(String[] args) {
    new _0215_KthLargestElementInAnArray_6()
      .findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
  }
}
