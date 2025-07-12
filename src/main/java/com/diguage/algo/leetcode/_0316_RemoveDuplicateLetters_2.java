package com.diguage.algo.leetcode;

public class _0316_RemoveDuplicateLetters_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-24 20:39:51
   */
  public String removeDuplicateLetters(String s) {
    char[] chars = s.toCharArray();
    int[] count = new int[26];
    for (char c : chars) {
      count[c - 'a']++;
    }
    boolean[] added = new boolean[26];
    // result 就是一个“单调栈”
    StringBuilder result = new StringBuilder();
    for (char c : chars) {
      int idx = c - 'a';
      count[idx]--;
      if (added[idx]) {
        continue;
      }
      // 类似单调栈的操作：单调递增栈，遇到小的，则大的出栈
      while (!result.isEmpty() && result.charAt(result.length() - 1) > c) {
        int lastCharIdx = result.charAt(result.length() - 1) - 'a';
        // 如果 result 最后一个字符后续不再出现，则必须保留了。
        if (count[lastCharIdx] == 0) {
          break;
        }
        // 否则，删除。后续再遇到了再添加
        result.deleteCharAt(result.length() - 1);
        added[lastCharIdx] = false;
      }
      result.append(c);
      added[idx] = true;
    }
    return result.toString();
  }
  // end::answer[]
}
