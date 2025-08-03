package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _0405_ConvertANumberToHexadecimal {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-03 21:17:55
   */
  public String toHex(int num) {
    int[] bits = getBits(num);
    Map<Integer, Character> map = Map.of(
      10, 'a',
      11, 'b',
      12, 'c',
      13, 'd',
      14, 'e',
      15, 'f');
    StringBuilder sb = new StringBuilder();
    int len = bits.length;
    for (int i = 0; i < len; i += 4) {
      int hexNum = bits[i]
        + (i + 1 < len ? bits[i + 1] * 2 : 0)
        + (i + 2 < len ? bits[i + 2] * 4 : 0)
        + (i + 3 < len ? bits[i + 3] * 8 : 0);
      if (hexNum < 10) {
        sb.append(hexNum);
      } else {
        sb.append(map.get(hexNum));
      }
    }
    return sb.reverse().toString();
  }

  private int[] getBits(int pos) {
    if (pos == 0) {
      return new int[]{0};
    }

    List<Integer> bits = new ArrayList<>();
    while (pos != 0) {
      bits.add(pos & 1);
      pos >>>= 1;
    }
    return bits.stream().mapToInt(Integer::intValue).toArray();
  }

  // end::answer[]

  public static void main(String[] args) {
    System.out.println(new _0405_ConvertANumberToHexadecimal().toHex(0));
  }
}
