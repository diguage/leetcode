package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0811_SubdomainVisitCount {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-05 21:38:16
   */
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> counter = new HashMap<>();
    for (String cpdomain : cpdomains) {
      int index = cpdomain.indexOf(" ");
      int count = Integer.parseInt(cpdomain.substring(0, index));
      String domain = cpdomain.substring(index + 1);
      while (!domain.isEmpty()) {
        counter.put(domain, counter.getOrDefault(domain, 0) + count);
        int idx = domain.indexOf(".");
        if (idx == -1) {
          break;
        }
        domain = domain.substring(idx + 1);
      }
    }
    List<String> result = new ArrayList<>(counter.size());
    counter.forEach((key, value) -> {
      result.add(value + " " + key);
    });
    return result;
  }
  // end::answer[]
}
