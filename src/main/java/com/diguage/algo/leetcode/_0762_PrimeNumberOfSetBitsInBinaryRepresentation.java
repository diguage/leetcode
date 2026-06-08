package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0762_PrimeNumberOfSetBitsInBinaryRepresentation {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-08 23:21:41
   */
  public int countPrimeSetBits(int left, int right) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = left; i <= right; i++) {
      int cnt = count(i);
      if (cnt < 2) {
        continue;
      }
      map.put(cnt, map.getOrDefault(cnt, 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (isPrime(entry.getKey())) {
        count += entry.getValue();
      }
    }
    return count;
  }

  private boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  private int count(int num) {
    int result = 0;
    while (num != 0) {
      result += (num & 1);
      num >>= 1;
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0762_PrimeNumberOfSetBitsInBinaryRepresentation()
      .countPrimeSetBits(6, 10);
  }
}
