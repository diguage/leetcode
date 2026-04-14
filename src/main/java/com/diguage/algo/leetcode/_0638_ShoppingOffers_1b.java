package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0638_ShoppingOffers_1b {
  // tag::answer[]

  /**
   * 暴力破解（11.29%） -> 备忘录（25.81%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-14 22:07:03
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
    Map<List<Integer>, Integer> memo = new HashMap<>();
    return dfs(price, filtered, needs, memo);
  }

  private int dfs(List<Integer> price, List<List<Integer>> specials,
                  List<Integer> needs, Map<List<Integer>, Integer> memo) {
    if (memo.containsKey(needs)) {
      return memo.get(needs);
    }
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
        result = Math.min(result, dfs(price, specials, nextNeeds, memo) + spec.get(n));
      }
    }
    memo.put(needs, result);
    return result;
  }
  // end::answer[]
}
