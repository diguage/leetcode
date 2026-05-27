package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0722_RemoveComments {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-27 22:39:30
   */
  public List<String> removeComments(String[] source) {
    List<String> result = new ArrayList<>();
    StringBuilder newLine = new StringBuilder();
    boolean inBlock = false;
    for (String line : source) {
      for (int i = 0; i < line.length(); i++) {
        if (inBlock) {
          if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
            inBlock = false;
            i++;
          }
        } else {
          if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
            inBlock = true;
            i++;
          } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
            break;
          } else {
            newLine.append(line.charAt(i));
          }
        }
      }
      if (!inBlock && !newLine.isEmpty()) {
        result.add(newLine.toString());
        newLine.setLength(0);
      }
    }
    return result;
  }

  // end::answer[]
//  public List<String> removeComments(String[] source) {
//    List<String> result = new ArrayList<>();
//    boolean flag = false;
//    for (String line : source) {
//      if (flag) {
//        int c = line.indexOf("*/");
//        if (c != -1 && c < line.length() - 1) {
//          flag = parse(line.substring(c + 2), result);
//        }
//      } else {
//        flag = parse(line, result);
//      }
//    }
//    return result;
//  }
//
//  private static boolean parse(String line, List<String> result, boolean append) {
//    if (line.isEmpty()) {
//      return false;
//    }
//    boolean flag = false;
//    int a = line.indexOf("//");
//    int b = line.indexOf("/*");
//    if (a == -1 && b == -1) {
//      result.add(line);
//    } else if (a != -1 && b != -1) {
//      int index = Math.min(a, b);
//      if (index > 0) {
//        result.add(line.substring(0, index));
//      }
//      if (b < a) {
//        flag = true;
//      }
//    } else if (a == -1) {
//      if (b > 0) {
//        result.add(line.substring(0, b));
//        line = line.substring(b + 2);
//      }
//      int c = line.indexOf("*/");
//      if (c == -1) {
//        flag = true;
//      } else {
//        if (c < line.length() - 2) {
//          flag = parse(line.substring(c + 2), result);
//        }
//      }
//    } else {
//      if (a > 0) {
//        result.add(line.substring(0, a));
//      }
//    }
//    return flag;
//  }
  static void main() {
    new _0722_RemoveComments().removeComments(new String[]{
//      "/*Test program */",
//      "int main()",
//      "{ ",
//      "  // variable declaration ",
//      "int a, b, c;",
//      "/* This is a test",
//      "   multiline  ",
//      "   comment for ",
//      "   testing */",
//      "a = b + c;",
//      "}"
      "a/*comment",
      "line",
      "more_comment*/b"
    });
  }
}
