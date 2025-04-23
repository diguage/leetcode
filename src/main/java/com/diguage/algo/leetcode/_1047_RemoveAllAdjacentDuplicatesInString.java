package com.diguage.algo.leetcode;

public class _1047_RemoveAllAdjacentDuplicatesInString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-23 21:41:43
   */
  public String removeDuplicates(String s) {
    // 使用 SB 当做栈，逐步推进
    //    StringBuilder stack = new StringBuilder();
    //    int top = -1;
    //    for (int i = 0; i < s.length(); i++) {
    //      char c = s.charAt(i);
    //      if (top >= 0 && stack.charAt(top) == c) {
    //        stack.deleteCharAt(top);
    //        top--;
    //      } else {
    //        stack.append(c);
    //        top++;
    //      }
    //    }
    //    return stack.toString();
    // 同样的思路，直接在数组上操作。
    char[] chars = s.toCharArray();
    int top = -1;
    for (int i = 0; i < chars.length; i++) {
      if (top == -1 || chars[top] != chars[i]) {
        chars[++top] = chars[i];
      } else {
        top--;
      }
    }
    return new String(chars, 0, top + 1);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1047_RemoveAllAdjacentDuplicatesInString()
      .removeDuplicates("abbbaca");
  }
}
