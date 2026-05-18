package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0692_TopKFrequentWords {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-18 22:19:24
   */
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<String> mergedWords = new ArrayList<>(map.keySet());
    sort(mergedWords, k, map, 0, mergedWords.size() - 1);
    return mergedWords.subList(0, k);
  }

  private void sort(List<String> words, int k, Map<String, Integer> map,
                    int lo, int hi) {
    if (k < lo || hi <= lo) {
      return;
    }
    int ie = partition(words, map, lo, hi);
    sort(words, k, map, lo, ie - 1);
    sort(words, k, map, ie + 1, hi);
  }
  private int partition(List<String> words, Map<String, Integer> map, int lo, int hi) {
    String sWord = words.get(lo);
    int point = map.get(sWord);
    int i = lo, j = hi + 1;
    while (true) {
      // 次数倒排，自然正排
      while (map.get(words.get(++i)) > point
        || (map.get(words.get(i)) == point && words.get(i).compareTo(sWord) < 0)) {
        if (i == hi) {
          break;
        }
      }
      while (map.get(words.get(--j)) < point
        || (map.get(words.get(j)) == point) && words.get(j).compareTo(sWord) > 0) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      swap(words, i, j);
    }
    swap(words, lo, j);
    return j;
  }
  private static void swap(List<String> words, int i, int j) {
    String temp = words.get(i);
    words.set(i, words.get(j));
    words.set(j, temp);
  }
  // end::answer[]
  static void main() {
    new _0692_TopKFrequentWords()
//      .topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
      .topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);

  }
}
