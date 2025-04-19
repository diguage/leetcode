package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * = 139. Word Break
 *
 * https://leetcode.com/problems/word-break/[Word Break - LeetCode]
 *
 * Given a *non-empty* string s and a dictionary wordDict containing a list of *non-empty* words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * *Note:*
 *
 * * The same word in the dictionary may be reused multiple times in the segmentation.
 * * You may assume the dictionary does not contain duplicate words.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 09:39
 */
public class _0139_WordBreak {
  // tag::answer[]
    /**
     * Runtime: 11 ms, faster than 6.65% of Java online submissions for Word Break.
     *
     * Memory Usage: 44.3 MB, less than 5.08% of Java online submissions for Word Break.
     *
     * Copy from: https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/[单词拆分 - 单词拆分 - 力扣（LeetCode）]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-24 09:39
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

  // end::answer[]


    public static void main(String[] args) {
        _0139_WordBreak solution = new _0139_WordBreak();

        boolean r4 = solution.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        System.out.println(r4);

        boolean r1 = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(r1);

        boolean r2 = solution.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(r2);

        boolean r3 = solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(!r3);
    }
}
