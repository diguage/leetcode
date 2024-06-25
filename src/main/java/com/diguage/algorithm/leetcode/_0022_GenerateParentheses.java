package com.diguage.algorithm.leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * = 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * ----
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-27 08:11
 */
public class _0022_GenerateParentheses {
  /**
   * Runtime: 2 ms, faster than 21.88% of Java online submissions for Generate Parentheses.
   *
   * Memory Usage: 45.3 MB, less than 5.16% of Java online submissions for Generate Parentheses.
   *
   * Copy from: https://leetcode.com/problems/generate-parentheses/solution/[Generate Parentheses solution - LeetCode]
   */
  public List<String> generateParenthesis(int n) {
    List<String> ans = new LinkedList<>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> result, String curr, int open, int close, int n) {
    if (curr.length() == 2 * n) {
      result.add(curr);
      return;
    }
    if (open < n) {
      backtrack(result, curr + "(", open + 1, close, n);
    }
    if (close < open) {
      backtrack(result, curr + ")", open, close + 1, n);
    }
  }


  public static void main(String[] args) {
    _0022_GenerateParentheses solution = new _0022_GenerateParentheses();

    List<String> r3 = solution.generateParenthesis(3);
    r3.sort(Comparator.naturalOrder());
    List<String> p3 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    p3.sort(Comparator.naturalOrder());
    System.out.println("▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽");
    System.out.println((p3.equals(r3)) + " : \n"
      + Arrays.toString(r3.toArray(new String[0])) + "\n"
      + Arrays.toString(p3.toArray(new String[0])));
    System.out.println("△△△△△△△△△△△△△△△△△△△△");

    List<String> r4 = solution.generateParenthesis(4);
    r4.sort(Comparator.naturalOrder());
    List<String> p4 = Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()");
    p4.sort(Comparator.naturalOrder());
    System.out.println("▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽");
    System.out.println((p4.equals(r4)) + " : \n"
      + Arrays.toString(r4.toArray(new String[0])) + "\n"
      + Arrays.toString(p4.toArray(new String[0])));
    System.out.println("△△△△△△△△△△△△△△△△△△△△");
  }
}
