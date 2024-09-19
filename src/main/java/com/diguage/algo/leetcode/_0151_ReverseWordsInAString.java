package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0151_ReverseWordsInAString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 17:11:20
   */
  public String reverseWords(String s) {
    Deque<String> stack = new LinkedList<>();
    boolean inWord = false;
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        inWord = false;
      } else {
        if (!inWord) {
          stack.push(String.valueOf(c));
          inWord = true;
        } else {
          stack.push(stack.pop() + c);
        }
      }
    }
    StringBuilder sb = new StringBuilder(s.length());
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
  // end::answer[]
}
