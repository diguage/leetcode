package com.diguage.algo.leetcode;

public class _0165_CompareVersionNumbers {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-27 20:42:34
   */
  public int compareVersion(String version1, String version2) {
    int l1 = 0;
    int l2 = 0;
    while (l1 < version1.length() || l2 < version2.length()) {
      int v1 = 0;
      int l1n = l1;
      while (l1n < version1.length() && version1.charAt(l1n) != '.') {
        l1n++;
      }
      if (l1 < l1n) {
        v1 = Integer.parseInt(version1.substring(l1, l1n));
        l1 = l1n + 1;
      }
      int v2 = 0;
      int l2n = l2;
      while (l2n < version2.length() && version2.charAt(l2n) != '.') {
        l2n++;
      }
      if (l2 < l2n) {
        v2 = Integer.parseInt(version2.substring(l2, l2n));
        l2 = l2n + 1;
      }
      int compare = Integer.compare(v1, v2);
      if (compare != 0) {
        return compare;
      }
    }
    return 0;
    //    // 最简单的的方式
    //    StringTokenizer st1 = new StringTokenizer(version1, ".");
    //    StringTokenizer st2 = new StringTokenizer(version2, ".");
    //    while (st1.hasMoreTokens() || st2.hasMoreTokens()) {
    //      int v1 = st1.hasMoreTokens() ? Integer.parseInt(st1.nextToken()) : 0;
    //      int v2 = st2.hasMoreTokens() ? Integer.parseInt(st2.nextToken()) : 0;
    //      int compare = Integer.compare(v1, v2);
    //      if (compare != 0) {
    //        return compare;
    //      }
    //    }
    //    return 0;
  }
  // end::answer[]
}
