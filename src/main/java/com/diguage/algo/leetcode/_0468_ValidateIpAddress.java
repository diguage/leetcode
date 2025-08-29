package com.diguage.algo.leetcode;

public class _0468_ValidateIpAddress {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-29 22:41:18
   */
  public String validIPAddress(String queryIP) {
    if (queryIP == null || queryIP.isEmpty()) {
      return "Neither";
    }
    if (queryIP.contains(":")) {
      return validIPv6(queryIP);
    } else {
      return validIPv4(queryIP);
    }
  }

  private String validIPv4(String ip) {
    ip = ip.toLowerCase();
    boolean isValid = true;
    int index = 0;
    int cnt = 0;
    while (index < ip.length()) {
      int end = cnt < 3 ? ip.indexOf(".", index) : ip.length();
      if (end == -1) {
        isValid = false;
        break;
      }
      String part = ip.substring(index, end);
      if ((part.startsWith("0") && part.length() > 1)
        || part.isEmpty()
        || part.length() > 3
        || part.matches(".*[a-z.].*")
        || Integer.parseInt(part) > 255) {
        isValid = false;
        break;
      }
      index = end + 1;
      cnt++;
    }
    return isValid && cnt == 4 ? "IPv4" : "Neither";
  }

  private String validIPv6(String ip) {
    ip = ip.toLowerCase();
    boolean isValid = true;
    int index = 0;
    int cnt = 0;
    while (index < ip.length()) {
      int end = cnt < 7 ? ip.indexOf(":", index) : ip.length();
      if (end == -1) {
        isValid = false;
        break;
      }
      String part = ip.substring(index, end);
      if (part.isEmpty() || part.length() > 4 || part.matches(".*[g-z.:].*")) {
        isValid = false;
        break;
      }
      index = end + 1;
      cnt++;
    }
    return isValid && cnt == 8 ? "IPv6" : "Neither";
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0468_ValidateIpAddress().validIPAddress("1.0.1.");
  }
}
