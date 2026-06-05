package com.diguage.algo.leetcode;

import java.util.*;

public class _0745_PrefixAndSuffixSearch {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-05 21:59:46
   */
  class WordFilter {
    private Trie head;
    private Trie tail;
    private String[] words;

    public WordFilter(String[] words) {
      head = new Trie();
      tail = new Trie();
      this.words = words;
      for (int i = 0; i < words.length; i++) {
        char[] chars = words[i].toCharArray();
        add(head, chars, i, false);
        add(tail, chars, i, true);
      }
    }

    public int f(String pref, String suff) {
      Set<Integer> i1 = search(head, pref.toCharArray(), false);
      if (i1.isEmpty()) {
        return -1;
      }
      Set<Integer> i2 = search(tail, suff.toCharArray(), true);
      if (i2.isEmpty()) {
        return -1;
      }
      int result = -1;
      for (Integer i : i1) {
        if (!i2.contains(i)) {
          continue;
        }
        result = Math.max(result, i);
      }
      return result;
    }

    private void add(Trie trie, char[] word, int index, boolean reverse) {
      for (int i = 0; i < word.length; i++) {
        char c = word[reverse ? word.length - 1 - i : i];
        int idx = c - 'a';
        if (trie.children[idx] == null) {
          trie.children[idx] = new Trie();
        }
        trie = trie.children[idx];
        if (i == word.length - 1) {
          trie.index = Math.max(trie.index, index);
        }
      }
    }

    private Set<Integer> search(Trie trie, char[] word, boolean reverse) {
      for (int i = 0; i < word.length; i++) {
        int idx = word[reverse ? word.length - 1 - i : i] - 'a';
        if (trie.children[idx] == null) {
          return Collections.emptySet();
        }
        trie = trie.children[idx];
      }
      Set<Integer> result = new HashSet<>();
      Queue<Trie> queue = new LinkedList<>(List.of(trie));
      while (!queue.isEmpty()) {
        Trie node = queue.poll();
        if (node.index >= 0) {
          result.add(node.index);
        }
        for (Trie child : node.children) {
          if (Objects.isNull(child)) {
            continue;
          }
          queue.offer(child);
        }
      }
      return result;
    }

    private static class Trie {
      private final Trie[] children = new Trie[26];
      // 这个地方可以优化一下，在每一层都加入坐标，
      // 这样就不需要深度遍历到叶子节点。
      private int index = -1;
    }
  }

  // end::answer[]
//  static void main() {
//    System.out.println(new WordFilter(new String[]{"apple"}).f("a", "e"));
//  }
}
