package com.diguage.algo.leetcode;

import java.util.Set;

public class _0345_ReverseVowelsOfAString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-15 22:59:15
   */
  public String reverseVowels(String s) {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u',
      'A', 'E', 'I', 'O', 'U');
    char[] chars = s.toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
      if (vowels.contains(chars[left]) && vowels.contains(chars[right])) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      } else {
        if (!vowels.contains(chars[left])) {
          left++;
        }
        if (!vowels.contains(chars[right])) {
          right--;
        }
      }
    }
    return new String(chars);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0345_ReverseVowelsOfAString().reverseVowels("IceCreAm");
  }
}
