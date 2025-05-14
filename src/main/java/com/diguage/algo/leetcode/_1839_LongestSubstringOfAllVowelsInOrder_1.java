package com.diguage.algo.leetcode;

public class _1839_LongestSubstringOfAllVowelsInOrder_1 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-14 15:41:55
   */
  public int longestBeautifulSubstring(String word) {
    // 注意：这里直接 cnt = 1，并且从 r = 1 开始遍历，
    // 已经假设 word[0] == a（假设不成立也不影响结果正确）
    int l = 0, cnt = 1, result = 0;
    for (int r = 1; r < word.length(); r++) {
      if (word.charAt(r - 1) > word.charAt(r)) {
        l = r;
        cnt = 1;
      } else if (word.charAt(r - 1) < word.charAt(r)) {
        cnt++;
      }
      if (cnt == 5) {
        result = Math.max(result, r - l + 1);
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1839_LongestSubstringOfAllVowelsInOrder_1()
      .longestBeautifulSubstring("aeiou");
  }
}
