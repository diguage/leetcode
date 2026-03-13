package com.diguage.algo.leetcode;


import java.util.ArrayList;
import java.util.List;

public class _0557_ReverseWordsInAStringIii {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-13 22:10:53
   */
  public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    int left = 0, right = chars.length - 1;
    while (left < right) {
      char c = chars[left];
      chars[left] = chars[right];
      chars[right] = c;
      left++;
      right--;
    }
    String r1 = new String(chars);
    List<String> words = new ArrayList<>();
    int index = 0;
    while (index < r1.length()) {
      int fast = index;
      while (fast < r1.length() && r1.charAt(fast) != ' ') {
        fast++;
      }
      words.add(r1.substring(index, fast));
      index = fast + 1;
    }
    left = 0;
    right = words.size() - 1;
    while (left < right) {
      String w = words.get(left);
      words.set(left, words.get(right));
      words.set(right, w);
      left++;
      right--;
    }
    StringBuilder sb = new StringBuilder(r1.length());
    for (String word : words) {
      sb.append(word).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  // end::answer[]
  static void main() {
    new _0557_ReverseWordsInAStringIii()
      .reverseWords("Let's take LeetCode contest");
  }
}
