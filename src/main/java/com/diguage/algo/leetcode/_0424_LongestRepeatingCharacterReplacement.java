package com.diguage.algo.leetcode;


public class _0424_LongestRepeatingCharacterReplacement {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-12 21:31:23
   */
  public int characterReplacement(String s, int k) {
    int[] counter = new int[26];
    char[] chars = s.toCharArray();
    int left = 0, right = 0, max = 0, result = 0;
    while (right < chars.length) {
      int index = chars[right] - 'A';
      counter[index]++;
      max = Math.max(max, counter[index]);
      right++;
      if (right - left > max + k) {
        counter[chars[left] - 'A']--;
        left++;
      }
      result = Math.max(result, right - left);
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0424_LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1);
  }
}
