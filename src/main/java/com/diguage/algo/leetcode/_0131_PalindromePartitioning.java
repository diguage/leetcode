package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 131. Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/[Palindrome Partitioning - LeetCode]
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * .Example:
 * [source]
 * ----
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-04 19:04
 */
public class _0131_PalindromePartitioning {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 94.23% of Java online submissions for Palindrome Partitioning.
     * Memory Usage: 39.2 MB, less than 95.45% of Java online submissions for Palindrome Partitioning.
     *
     * Copy from: https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java%3A-Backtracking-solution.[Java: Backtracking solution. - LeetCode Discuss]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-04 19:04
     */
    public List<List<String>> partition(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return Collections.emptyList();
        }
        List<List<String>> result = new LinkedList<>();
        List<String> current = new ArrayList<>();
        dfs(s, 0, current, result);
        return result;
    }

    private void dfs(String s, int index, List<String> current, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    current.add(s.substring(index, i + 1));
                    dfs(s, i + 1, current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (!Objects.equals(s.charAt(low++), s.charAt(high--))) {
                return false;
            }
        }
        return true;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0131_PalindromePartitioning solution = new _0131_PalindromePartitioning();
        String s1 = "aab";
        List<List<String>> r1 = solution.partition(s1);
        System.out.println(Arrays.deepToString(r1.toArray()));
    }
}
