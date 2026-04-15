package com.diguage.algo.leetcode;

public class _0639_DecodeWaysIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-15 08:43:34
   */
  public int numDecodings(String s) {
    int MOD = 1_000_000_007;
    long a = 0, b = 1, c = 0;
    for (int i = 1; i <= s.length(); i++) {
      c = b * check1Digit(s.charAt(i - 1)) % MOD;
      if (i > 1) {
        c = (c + (a * check2Digit(s.charAt(i - 2), s.charAt(i - 1))) % MOD) % MOD;
      }
      a = b;
      b = c;
    }
    return (int) c;
  }

  private int check1Digit(char c) {
    if (c == '0') {
      return 0;
    }
    return c == '*' ? 9 : 1;
  }

  private long check2Digit(char h, char t) {
    if (h == '*' && t == '*') {
      return 15;
    }
    if (h == '*') {
      return t <= '6' ? 2 : 1;
    }
    if (t == '*') {
      if (h == '1') {
        return 9;
      }
      if (h == '2') {
        return 6;
      }
      return 0;
    }
    return (h != '0' && (h - '0') * 10 + (t - '0') <= 26) ? 1 : 0;
  }

  // end::answer[]
// return (dfs(s, MOD, 0, 1) + dfs(s, MOD, 0, 2)) % MOD;
//  private int dfs(String s, int mod, int index, int length) {
//    if (index >= s.length()
//      || index + length > s.length()) {
//      return 0;
//    }
//    char head = s.charAt(index);
//    if ((length == 2 && '3' <= head && head <= '9')
//      || head == '0') {
//      return 0;
//    }
//    if (length == 1) {
//      int count = 1;
//      if (head == '*') {
//        count = 9;
//      }
//      return (count * (dfs(s, mod, index + 1, 1)
//        + dfs(s, mod, index + 1, 2))) % mod;
//    } else {
//      int count = 0;
//      char tail = s.charAt(index + 1);
//      if (head == '*' && tail == '*') {
//        count = 15;
//      } else if (head == '*') {
//        count = tail <= '6' ? 2 : 1;
//      } else if (tail == '*') {
//        if (head == '1') {
//          count = 9;
//        } else if (head == '2') {
//          count = 6;
//        }
//      } else {
//        count = (head - '0') * 10 + (tail - '0') <= 26 ? 1 : 0;
//      }
//      return (count * ((dfs(s, mod, index + 2, 1)
//        + dfs(s, mod, index + 2, 2)) % mod)) % mod;
//    }
//  }


  static void main() {
    int count = new _0639_DecodeWaysIi()
//      .numDecodings("*");
      .numDecodings("1*");
    System.out.println(count);
  }
}
