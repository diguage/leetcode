package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0904_FruitIntoBaskets {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-27 15:33:58
   */
  public int totalFruit(int[] fruits) {
    int result = 0;
    int head = 0, tail = 0;
    Map<Integer, Integer> fruitToCntMap = new HashMap<>();
    while (head < fruits.length) {
      int f1 = fruits[head];
      head++;
      Integer cnt = fruitToCntMap.getOrDefault(f1, 0);
      fruitToCntMap.put(f1, cnt + 1);
      if (fruitToCntMap.size() <= 2) {
        result = Math.max(result, head - tail);
      } else {
        while (tail < head && fruitToCntMap.size() > 2) {
          int f2 = fruits[tail];
          Integer c2 = fruitToCntMap.get(f2);
          if (c2 >1) {
            fruitToCntMap.put(f2, c2 - 1);
          }else {
            fruitToCntMap.remove(f2);
          }
          tail++;
        }
      }
    }
    return result;
  }
  // end::answer[]
}
