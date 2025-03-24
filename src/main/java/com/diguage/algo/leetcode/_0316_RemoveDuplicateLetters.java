package com.diguage.algo.leetcode;

public class _0316_RemoveDuplicateLetters {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-16 19:08
   */
  public String removeDuplicateLetters(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    boolean[] visited = new boolean[26];
    StringBuilder chars = new StringBuilder();
    for (char c : s.toCharArray()) {
      int idx = c - 'a';
      count[idx]--;
      if (visited[idx]) {
        continue;
      }
      while (!chars.isEmpty() && chars.charAt(chars.length() - 1) > c) {
        int lastIdx = chars.charAt(chars.length() - 1) - 'a';
        // 如果已选中的最后一个字符，在后续字符串中没有了，就不能再删除了。
        if (count[lastIdx] == 0) {
          break;
        }
        // 否则，删除掉。后面还可以再加进来
        chars.deleteCharAt(chars.length() - 1);
        visited[lastIdx] = false;
      }
      chars.append(c);
      visited[idx] = true;
    }
    return chars.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    _0316_RemoveDuplicateLetters solution = new _0316_RemoveDuplicateLetters();
    String result = solution.removeDuplicateLetters("bcabc");
    System.out.println(result);
  }
}
