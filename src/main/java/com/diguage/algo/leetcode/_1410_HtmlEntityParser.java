package com.diguage.algo.leetcode;

import java.util.Map;

public class _1410_HtmlEntityParser {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-22 22:59:23
   */
  public String entityParser(String text) {
    Map<String, String> map = Map.of(
      "&quot;", "\"",
      "&apos;", "'",
      "&amp;", "&",
      "&gt;", ">",
      "&lt;", "<",
      "&frasl;", "/");
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '&') {
        if (!temp.isEmpty()) {
          sb.append(temp);
          temp.setLength(0);
        }
        temp.append(c);
        flag = true;
      } else if (c == ';') {
        temp.append(c);
        String entry = temp.toString();
        String s = map.get(entry);
        if (s != null) {
          sb.append(s);
        } else {
          sb.append(entry);
        }
        temp.setLength(0);
        flag = false;
      } else {
        if (flag) {
          temp.append(c);
        } else {
          sb.append(c);
        }
      }
    }
    if (!temp.isEmpty()) {
      sb.append(temp);
    }
    return sb.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1410_HtmlEntityParser()
      .entityParser("&amp; is an HTML entity but &ambassador; is not.");
  }
}
