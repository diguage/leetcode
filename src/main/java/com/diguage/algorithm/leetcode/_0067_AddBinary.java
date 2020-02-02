package com.diguage.algorithm.leetcode;

/**
 * = 67. Add Binary
 *
 * https://leetcode.com/problems/add-binary/[Add Binary - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-02 22:27
 */
public class _0067_AddBinary {
    /**
     * Runtime: 2 ms, faster than 64.49% of Java online submissions for Add Binary.
     * Memory Usage: 38.3 MB, less than 5.62% of Java online submissions for Add Binary.
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carr = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int ai = i >= 0 ? a.charAt(i) - '0' : 0;
            int bi = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = carr + ai + bi;
            result.append(sum & 1);
            carr = (sum >>> 1) & 1;
        }
        result.append(carr > 0 ? carr : "");
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        _0067_AddBinary sollution = new _0067_AddBinary();
        String r1 = sollution.addBinary("11", "1");
        System.out.println("100".equals(r1) + " : " + r1);

        String r2 = sollution.addBinary("1010", "1011");
        System.out.println("10101".equals(r2) + " : " + r2);
    }
}
