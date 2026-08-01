package com.diguage.algo.leetcode;

public class _0844_BackspaceStringCompare {
  // tag::answer[]
  /**
   * 代码写的好丑！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-01 21:10:29
   */
  public boolean backspaceCompare(String s, String t) {
    int si = s.length() - 1;
    int ti = t.length() - 1;
    int sj = 0, tj = 0;
    while (si >= 0 || ti >= 0) {
      if (si >= 0 && s.charAt(si) != '#'
        && ti >= 0 && t.charAt(ti) != '#'
        && s.charAt(si) != t.charAt(ti)) {
        return false;
      }
      while (sj > 0 || (si >= 0 && s.charAt(si) == '#')) {
        if (si >= 0 && s.charAt(si) != '#' && sj > 0) {
          si--;
          sj--;
        } else if (si >= 0 && s.charAt(si) == '#') {
          si--;
          sj++;
        }
        if (si < 0) {
          break;
        }
      }
      while (tj > 0 || (ti >= 0 && t.charAt(ti) == '#')) {
        if (ti >= 0 && t.charAt(ti) != '#' && tj > 0) {
          ti--;
          tj--;
        } else if (ti >= 0 && t.charAt(ti) == '#') {
          ti--;
          tj++;
        }
        if (ti < 0) {
          break;
        }
      }
      if (si >= 0 && ti >= 0 && s.charAt(si) != t.charAt(ti)) {
        return false;
      } else if (si < 0 && ti < 0) {
        break;
      } else if (si < 0 || ti < 0) {
        return false;
      }
      si--;
      ti--;
    }
    return true;
  }
  // end::answer[]

  static void main() {
    new _0844_BackspaceStringCompare()
      .backspaceCompare("nzp#o#g", "b#nzp#o#g");
//      .backspaceCompare("bxj##tw", "bxj###tw");
//      .backspaceCompare("a##c", "#a#c");
//      .backspaceCompare("ab##", "c#d#");
//      .backspaceCompare("ab#c", "ad#c");
  }
}
