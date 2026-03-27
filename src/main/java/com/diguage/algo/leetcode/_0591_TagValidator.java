package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0591_TagValidator {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-27 21:33:39
   */
  public boolean isValid(String code) {
    if (code.length() < 7) {
      return false;
    }
    Deque<String> stack = new ArrayDeque<>();
    int length = code.length();
    int index = 0;
    String cStart = "<![CDATA[", cEnd = "]]>";
    while (index < length) {
      if (index > 0 && stack.isEmpty()) {
        return false;
      }
      if (code.charAt(index) == '<') {
        if (code.charAt(index + 1) == '/') {
          // 结束标签
          int end = 0;
          for (int i = index + 2; i < length; i++) {
            char c = code.charAt(i);
            if (c == '>') {
              end = i;
              break;
            }
            if (c < 'A' || 'Z' < c
              || i - index - 1 > 9) {
              return false;
            }
          }
          if (end == 0) {
            return false;
          }
          String endTag = code.substring(index + 2, end);
          if (stack.isEmpty() || !endTag.equals(stack.peek())) {
            return false;
          } else {
            stack.pop();
            index = end + 1;
          }
        } else if (code.indexOf(cStart, index) == index) {
          // CDATA
          int end = code.indexOf(cEnd, index + cStart.length());
          if (end < 0) {
            return false;
          } else {
            index = end + cEnd.length();
          }
        } else {
          // 开始标签
          int end = 0;
          for (int i = index + 1; i < length; i++) {
            char c = code.charAt(i);
            if (c == '>') {
              end = i;
              break;
            }
            if (c < 'A' || 'Z' < c
              || i - index - 1 > 9) {
              return false;
            }
          }
          if (end == 0 || end == index + 1) {
            return false;
          }
          String startTag = code.substring(index + 1, end);
          stack.push(startTag);
          index = end + 1;
        }
      } else {
        index++;
      }
    }
    return stack.isEmpty() && index == length;
  }
  // end::answer[]

  static void main() {
    new _0591_TagValidator()
//      .isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>");
//      .isValid("<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>");
//      .isValid("<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>");
//      .isValid("<A");
      .isValid("<DIV><YFSYYS><UVBNIQ><XPMXUNT><WNGMV><OJJGQREMT><Z><GEJDP><LIQS><NCVYU><RAS><UYFKCJCDN><NA><POJVYT><Z><TDC><VUIZQC><BNANGX><TOF><MR>MK</MR></TOF></BNANGX></VUIZQC></TDC></Z></POJVYT></NA></UYFKCJCDN></RAS></NCVYU></LIQS></GEJDP></Z></OJJGQREMT></WNGMV></XPMXUNT></UVBNIQ></YFSYYS></DIV>");
  }
}
