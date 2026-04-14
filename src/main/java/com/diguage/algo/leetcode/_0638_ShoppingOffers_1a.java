package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0638_ShoppingOffers_1a {
  // tag::answer[]
  /**
   * 暴力破解（11.29%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-14 21:47:37
   */
  public int shoppingOffers(List<Integer> price,
                            List<List<Integer>> special,
                            List<Integer> needs) {
    int size = price.size();
    List<List<Integer>> filtered = special.stream()
      .filter(s -> {
        int count = 0, sum = 0;
        for (int i = 0; i < size; i++) {
          count += s.get(i);
          sum += s.get(i) * price.get(i);
        }
        return count > 0 && sum > s.getLast();
      }).toList();
    // 暴力破解
    return dfs(price, filtered, needs);
  }

  private int dfs(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
    int result = 0;
    for (int i = 0; i < needs.size(); i++) {
      result += price.get(i) * needs.get(i);
    }
    int n = price.size();
    for (List<Integer> spec : specials) {
      List<Integer> nextNeeds = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (spec.get(i) > needs.get(i)) {
          break;
        }
        nextNeeds.add(needs.get(i) - spec.get(i));
      }
      if (nextNeeds.size() == n) {
        result = Math.min(result, dfs(price, specials, nextNeeds) + spec.get(n));
      }
    }
    return result;
  }
  // end::answer[]
}
