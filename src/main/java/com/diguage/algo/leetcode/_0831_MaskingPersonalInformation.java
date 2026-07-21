package com.diguage.algo.leetcode;

public class _0831_MaskingPersonalInformation {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-20 22:31:30
   */
  public String maskPII(String s) {
    boolean isEmail = s.contains("@");
    if (isEmail) {
      return maskEmail(s);
    } else {
      return maskPhone(s);
    }
  }

  private String maskPhone(String s) {
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      char c = chars[i];
      if ('0' <= c && c <= '9') {
        if (sb.length() < 4) {
          sb.append(c);
        } else {
          sb.append('*');
        }
        if (sb.length() == 4 || sb.length() == 8 || sb.length() == 12) {
          sb.append('-');
        }
      }
    }
    if (sb.charAt(sb.length() - 1) == '-') {
      sb.setLength(sb.length() - 1);
    }
    if (sb.length() > 12) {
      sb.append('+');
    }
    return sb.reverse().toString();
  }

  private String maskEmail(String s) {
    String[] split = s.split("@");
    String name = split[0];
    String domain = split[1];
    StringBuilder sb = new StringBuilder();
    sb.append(toLow(name.charAt(0))).append("*****").append(toLow(name.charAt(name.length() - 1)));
    sb.append("@");
    for (char c : domain.toCharArray()) {
      if ('A' <= c && c <= 'Z') {
        sb.append(toLow(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private static char toLow(char c) {
    return (char) (c | 0b10_0000);
  }
  // end::answer[]
}
