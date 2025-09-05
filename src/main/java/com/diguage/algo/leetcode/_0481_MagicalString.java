package com.diguage.algo.leetcode;

public class _0481_MagicalString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-05 22:12:46
   */
  public int magicalString(int n) {
    // 节省空间的解法：false 表示 1，true 表示 2
    boolean[] s = new boolean[n + 2];
    s[1] = false;
    s[1] = s[2] = true;
    boolean c = true;
    for (int i = 2, j = 3; j < n; i++) {
      c = !c;
      s[j++] = c;
      if (s[i]) {
        s[j++] = c;
      }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (!s[i]) {
        result++;
      }
    }
    return result;
    // 原始解法
    //  char[] s = new char[n + 2];
    //  s[0] = '1';
    //  s[1] = s[2] = '2';
    //  int c = 2;
    //  for (int i = 2, j = 3; j < n; i++) {
    //    c ^= 3; // 1^3=2, 2^3=1，这样就能在 1 和 2 之间转换
    //    s[j++] = (char) (c + '0');
    //    if (s[i] == (char) (2 + '0')) {
    //      s[j++] = (char) (c + '0');
    //    }
    //  }
    //  int result = 0;
    //  for (int i = 0; i < n; i++) {
    //    result += 2 - (s[i] - '0');
    //  }
    //  return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0481_MagicalString().magicalString(50);
  }
}
