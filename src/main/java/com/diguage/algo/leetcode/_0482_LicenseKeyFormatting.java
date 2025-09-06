package com.diguage.algo.leetcode;

public class _0482_LicenseKeyFormatting {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-05 22:12:46
   */
  public String licenseKeyFormatting(String s, int k) {
    StringBuilder sb = new StringBuilder(s.length());
    int index = s.length() - 1;
    while (index >= 0) {
      int start = sb.length();
      while (sb.length() - start < k) {
        if (s.charAt(index) == '-') {
          index--;
          if (index < 0) {
            break;
          } else {
            continue;
          }
        }
        sb.append(s.charAt(index));
        index--;
        if (index < 0) {
          break;
        }
      }
      if (index < 0) {
        break;
      }
      sb.append('-');
    }
    if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '-') {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.reverse().toString().toUpperCase();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0482_LicenseKeyFormatting().licenseKeyFormatting("--a-a-a-a--", 2);
  }
}
