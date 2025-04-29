package com.diguage.algo.leetcode;

public class _0211_DesignAddAndSearchWordsDataStructure {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-30 00:08:59
   */
  static class WordDictionary {
    private WordDictionary[] letters;
    private boolean end = false;

    public WordDictionary() {
      letters = new WordDictionary[26];
    }

    public void addWord(String word) {
      char[] chars = word.toCharArray();
      WordDictionary current = this;
      for (int i = 0; i < chars.length; i++) {
        if (current.letters[chars[i] - 'a'] == null) {
          current.letters[chars[i] - 'a'] = new WordDictionary();
        }
        current = current.letters[chars[i] - 'a'];
        if (i == chars.length - 1) {
          current.end = true;
        }
      }
    }

    public boolean search(String word) {
      char[] chars = word.toCharArray();
      return backtrack(chars, 0, this);
    }

    private boolean backtrack(char[] chars, int index,
                              WordDictionary current) {
      if (index == chars.length) {
        return true;
      }
      if (chars[index] == '.') {
        for (int i = 0; i < 26; i++) {
          if (current.letters[i] == null) {
            continue;
          }
          if (index == chars.length - 1) {
            if (current.letters[i].end) {
              return true;
            } else {
              continue;
            }
          }
          boolean ok = backtrack(chars, index + 1, current.letters[i]);
          if (ok) {
            return true;
          }
        }
        return false;
      } else {
        WordDictionary next = current.letters[chars[index] - 'a'];
        if (next == null) {
          return false;
        } else {
          if (index == chars.length - 1) {
            return next.end;
          }
          return backtrack(chars, index + 1, next);
        }
      }
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    WordDictionary dict = new WordDictionary();
    // "addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"
    // ["at"],    ["and"],  ["an"],  ["add"],  ["a"],    [".at"], ["bat"],  [".at"], ["an."], ["a.d."], ["b."], ["a.d"], ["."]
    dict.addWord("at");
    dict.addWord("and");
    dict.addWord("an");
    dict.addWord("add");
    dict.search("a");
    dict.search(".at");
    dict.search("bat");
    dict.search(".at");
    dict.search("an.");
    dict.search("a.d.");
    dict.search("b.");
    dict.search("a.d");
    dict.search(".");
    // "addWord","addWord","search","search","search","search","search","search","search","search"
    // ["a"],    ["ab"],   ["a"],   ["a."],   ["ab"],  [".a"]  ,[".b"],  ["ab."], ["."], [".."]
//    dict.addWord("a");
//    dict.addWord("ab");
//    dict.search("a");
//    dict.search("a.");
//    dict.search("ab");
//    dict.search(".a");
//    dict.search(".b");
//    dict.search("ab.");
//    dict.search(".");
//    dict.search("..");
  }
}
