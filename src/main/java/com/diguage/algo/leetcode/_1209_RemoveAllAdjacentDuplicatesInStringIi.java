package com.diguage.algo.leetcode;

public class _1209_RemoveAllAdjacentDuplicatesInStringIi {
  // tag::answer[]

  /**
   * 暴力解法： 通过 19 / 21 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-02 07:27:39
   */
  public String removeDuplicates(String s, int k) {
    if (s == null || s.length() < k) {
      return s;
    }
    StringBuilder sb = new StringBuilder(s);
    int length = sb.length();
    int index = 0;
    while (index < length) {
      char c = sb.charAt(index);
      int fast = index + 1;
      while (fast < length && c == sb.charAt(fast) && fast - index < k) {
        fast++;
      }
      int dc = fast - index;
      if (fast <= length && dc >= k) {
        sb.replace(index, fast, "");
        length = sb.length();
      } else {
        index = fast;
      }
    }
    if (sb.length() == s.length()) {
      return s;
    } else {
      return removeDuplicates(sb.toString(), k);
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1209_RemoveAllAdjacentDuplicatesInStringIi()
      .removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4);
  }
}
