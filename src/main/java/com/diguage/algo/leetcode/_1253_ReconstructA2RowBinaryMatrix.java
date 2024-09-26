package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1253_ReconstructA2RowBinaryMatrix {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-25 21:12:25
   */
  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int sum = 0;
    int twos = 0;
    for (int num : colsum) {
      sum += num;
      if (num == 2) {
        twos++;
      }
    }
    if (sum != upper + lower || upper < twos || lower < twos) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>(2);
    result.add(new ArrayList<>(colsum.length));
    result.add(new ArrayList<>(colsum.length));
    upper -= twos;
    lower -= twos;
    for (int i = 0; i < colsum.length; i++) {
      int up = 0;
      int low = 0;
      if (colsum[i] == 2) {
        up = 1;
        low = 1;
      } else if (colsum[i] == 1) {
        if (upper > 0) {
          up = 1;
          upper--;
        } else {
          low = 1;
          lower--;
        }
      }
      result.get(0).add(up);
      result.get(1).add(low);
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1253_ReconstructA2RowBinaryMatrix()
      .reconstructMatrix(5, 5,
        new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});

  }
}
