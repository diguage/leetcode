package com.diguage.algo.leetcode;

public class _1209_RemoveAllAdjacentDuplicatesInStringIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-02 07:27:39
   */
  public String removeDuplicates(String s, int k) {
    StringBuilder sb = new StringBuilder(s);
    int[] count = new int[s.length()];
    for (int i = 0; i < sb.length(); i++) {
      if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
        count[i] = 1;
      } else {
        count[i] = count[i - 1] + 1;
        if (count[i] == k) {
          sb.delete(i - k + 1, i + 1);
          i -= k;
        }
      }
    }
    return sb.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1209_RemoveAllAdjacentDuplicatesInStringIi()
      .removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4);
  }
}
