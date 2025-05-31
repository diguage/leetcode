package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1023_CamelcaseMatching {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-31 20:11:57
   */
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> result = new ArrayList<>(queries.length);
    for (int i = 0; i < queries.length; i++) {
      result.add(isMatch(queries[i], pattern));
    }
    return result;
  }

  private boolean isMatch(String query, String pattern) {
    char[] chars = pattern.toCharArray();
    int m = 0, n = 0;
    StringBuilder sb = new StringBuilder(query.length());
    while (m < query.length() && n < chars.length) {
      char mc = query.charAt(m);
      char nc = chars[n];
      if (mc == nc) {
        m++;
        n++;
        sb.append(nc);
      } else if (Character.isUpperCase(mc)) {
        return false;
      } else {
        sb.append(mc);
        m++;
      }
    }
    if (n < chars.length) {
      return false;
    }
    for (int i = m; i < query.length(); i++) {
      char mc = query.charAt(i);
      if (Character.isUpperCase(mc)) {
        return false;
      }
      sb.append(mc);
    }
    return query.equals(sb.toString());
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1023_CamelcaseMatching().camelMatch(
      new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa");
  }
}
