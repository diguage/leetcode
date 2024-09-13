package com.diguage.algo.leetcode;

/**
 * = 343. Integer Break
 * <p>
 * https://leetcode.com/problems/integer-break/[Integer Break - LeetCode^]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-04-26 16:38
 */
public class _0343_IntegerBreak {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Break.
     * Memory Usage: 38.1 MB, less than 14.29% of Java online submissions for Integer Break.
     *
     * Copy from: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/[面试题14- I. 剪绳子（数学推导 / 贪心思想，清晰图解） - 剪绳子 - 力扣（LeetCode）]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-04-26 16:38
     */
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n / 3;
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, timeOf3);
        }
        if (mod == 1) {
            return (int) Math.pow(3, timeOf3 - 1) * (3 + 1);
        }
        return (int) Math.pow(3, timeOf3) * 2;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0343_IntegerBreak solution = new _0343_IntegerBreak();
        System.out.println(solution.integerBreak(10));
    }
}
