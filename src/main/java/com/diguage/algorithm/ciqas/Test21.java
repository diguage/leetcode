package com.diguage.algorithm.ciqas;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 19:04
 */
public class Test21 {
    public int[] exchange(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left >= right || left >= nums.length) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Test21 test = new Test21();
        System.out.println(Arrays.toString(test.exchange(new int[]{1, 3, 5})));
        System.out.println(Arrays.toString(test.exchange(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15})));
    }
}
