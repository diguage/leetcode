package com.diguage.algo.leetcode;

public class _0394_DecodeString_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 16:05:13
   */
  int idx = 0;
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    while (idx < s.length()) {
      char c = s.charAt(idx);
      if ('0' <= c && c <= '9') {
        sb.append(dfs(s));
      } else {
        sb.append(c);
        idx++;
      }
    }
    return sb.toString();
  }

  private String dfs(String s) {
    int cnt = 0;
    boolean isEnd = false;
    StringBuilder sb = new StringBuilder();
    while (idx < s.length()) {
      char c = s.charAt(idx);
      if ('0' <= c && c <= '9') {
        if (isEnd) {
          sb.append(dfs(s));
          continue;
        }
        int num = c - '0';
        if (cnt == 0) {
          cnt = num;
        } else {
          cnt = 10 * cnt + num;
        }
        idx++;
      } else if ('a' <= c && c <= 'z') {
        sb.append(c);
        idx++;
      } else if (c == '[') {
        isEnd = true;
        idx++;
      } else if (s.charAt(idx) == ']') {
        idx++;
        break;
      }
    }
    StringBuilder result = new StringBuilder();
    for (int j = 0; j < cnt; j++) {
      result.append(sb);
    }
    return result.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    _0394_DecodeString_2 solution = new _0394_DecodeString_2();
    String r1 = solution.decodeString("3[a]2[bc]");
    System.out.println("aaabcbc".equals(r1) + " : " + r1);

    String r2 = solution.decodeString("3[a2[c]]");
    System.out.println("accaccacc".equals(r2) + " : " + r2);

    String r3 = solution.decodeString("2[a3[b]4[c]]");
    System.out.println("abbbccccabbbcccc".equals(r3) + " : " + r3);
  }
}
