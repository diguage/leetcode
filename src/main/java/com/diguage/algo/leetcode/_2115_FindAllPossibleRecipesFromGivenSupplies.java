package com.diguage.algo.leetcode;

import java.util.*;

public class _2115_FindAllPossibleRecipesFromGivenSupplies {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-22 14:39:30
   */
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    int n = recipes.length;
    Map<String, Integer> inDegree = new HashMap<>();
    Map<String, Set<String>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String target = recipes[i];
      List<String> start = ingredients.get(i);
      for (String s : start) {
        graph.computeIfAbsent(s, key -> new HashSet<>()).add(target);
      }
      inDegree.put(target, inDegree.getOrDefault(target, 0) + start.size());
    }
    // 只有 recipes 统计入度，那么，所有 supplies 都可以作为起点
    Deque<String> queue = new ArrayDeque<>(Arrays.asList(supplies));
    while (!queue.isEmpty()) {
      String cur = queue.poll();
      for (String s : graph.getOrDefault(cur, Collections.emptySet())) {
        Integer ingress = inDegree.getOrDefault(s, 0) - 1;
        if (ingress == 0) {
          queue.offer(s);
        }
        inDegree.put(s, ingress);
      }
    }
    List<String> result = new ArrayList<>();
    for (String recipe : recipes) {
      if (inDegree.getOrDefault(recipe, 0) == 0) {
        result.add(recipe);
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _2115_FindAllPossibleRecipesFromGivenSupplies()
      .findAllRecipes(new String[]{"bread", "sandwich"},
        List.of(List.of("yeast", "flour"), List.of("bread", "meat")),
        new String[]{"yeast", "flour", "meat"});
  }
}
