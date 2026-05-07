package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0677_MapSumPairs {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-07 23:24:40
   */
  class MapSum {

    // 好简单的 Trie
    class Trie {
      Trie[] children = new Trie[26];
      int value;
    }

    private Trie root;
    private Map<String, Integer> map;


    public MapSum() {
      map = new HashMap<>();
      root = new Trie();
    }

    public void insert(String key, int val) {
      int delta = val - map.getOrDefault(key, 0);
      map.put(key, val);
      Trie node = root;
      for (char c : key.toCharArray()) {
        if (node.children[c - 'a'] == null) {
          node.children[c - 'a'] = new Trie();
        }
        node = node.children[c - 'a'];
        // 在树的一条从顶到叶的所有节点都存储了变化
        node.value += delta;
      }
    }

    public int sum(String prefix) {
      Trie node = root;
      for (char c : prefix.toCharArray()) {
        if (node.children[c - 'a'] == null) {
          return 0;
        }
        node = node.children[c - 'a'];
      }
      // 这里是已经汇总好的值了。
      return node.value;
    }
  }
  // end::answer[]
}
