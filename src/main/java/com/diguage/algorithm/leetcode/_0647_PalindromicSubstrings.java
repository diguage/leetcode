package com.diguage.algorithm.leetcode;

/**
 * = 647. Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/[Palindromic Substrings - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-31 23:17
 */
public class _0647_PalindromicSubstrings {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Palindromic Substrings.
     * Memory Usage: 37.8 MB, less than 11.39% of Java online submissions for Palindromic Substrings.
     *
     * Copy from: https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-by-leetcode/[回文子串 - 回文子串 - 力扣（LeetCode）]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-31 23:17
     */
    public int countSubstrings(String s) {
        char[] A = new char[2 * s.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int j = 2;
        for (char c : s.toCharArray()) {
            A[j++] = c;
            A[j++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; i++) {
            if (i < right) {
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1]) {
                Z[i]++;
            }
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int result = 0;
        for (int i : Z) {
            result += (i + 1) / 2;
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0647_PalindromicSubstrings solution = new _0647_PalindromicSubstrings();
        int r1 = solution.countSubstrings("abc");
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.countSubstrings("aaa");
        System.out.println((r2 == 6) + " : " + r2);
    }
}
