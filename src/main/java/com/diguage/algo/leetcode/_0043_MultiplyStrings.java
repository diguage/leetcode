package com.diguage.algo.leetcode;

/**
 * = 43. Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/[Multiply Strings - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-03 21:07
 */
public class _0043_MultiplyStrings {
  // tag::answer[]
    /**
     * Runtime: 5 ms, faster than 59.85% of Java online submissions for Multiply Strings.
     * Memory Usage: 38.5 MB, less than 16.67% of Java online submissions for Multiply Strings.
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] products = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int iNum = num1.charAt(i) - '0';
            if (iNum == 0) {
                continue;
            }
            for (int j = num2.length() - 1; j >= 0; j--) {
                int jNum = num2.charAt(j) - '0';
                int sum = products[i + j + 1] + iNum * jNum;
                products[i + j + 1] = sum % 10;
                products[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            if (i == 0 && products[i] == 0) {
                continue;
            }
            sb.append(products[i]);
        }
        return sb.toString();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0043_MultiplyStrings solution = new _0043_MultiplyStrings();
        String r5 = solution.multiply("7067", "7967");
        System.out.println("56302789".equals(r5) + " : " + r5);

        String r4 = solution.multiply("6", "501");
        System.out.println("3006".equals(r4) + " : " + r4);

        String r1 = solution.multiply("123", "456");
        System.out.println("56088".equals(r1) + " : " + r1);

        String r2 = solution.multiply("123", "4567");
        System.out.println("561741".equals(r2) + " : " + r2);

        String r3 = solution.multiply("88888888", "999999999");
        System.out.println("88888887911111112".equals(r3) + " : " + r3);
    }
}
