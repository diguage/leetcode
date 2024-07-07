package com.diguage.algo.ciqas;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 17:32
 */
public class Test03 {
    public int findRepeatNumber(int[] nums) {
        int[] ints = new int[100001];
        for (int num : nums) {
            if (ints[num] > 0) {
                return num;
            } else {
                ints[num]++;
            }
        }
        return 0;
    }
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>(nums.length / 2);
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return num;
//            } else {
//                set.add(num);
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {

    }
}
