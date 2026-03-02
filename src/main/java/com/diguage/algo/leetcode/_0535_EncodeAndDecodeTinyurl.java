package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0535_EncodeAndDecodeTinyurl {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-02 20:30:20
   */
  public class Codec {
    private String base = "http://tinyurl.com/";
    private Map<String, Integer> l2s = new HashMap<>();
    private Map<Integer, String> s2l = new HashMap<>();
    int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      if (!l2s.containsKey(longUrl)) {
        int value = counter++;
        l2s.put(longUrl, value);
        s2l.put(value, longUrl);
      }
      return base + l2s.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      int index = shortUrl.lastIndexOf('/') + 1;
      int value = Integer.parseInt(shortUrl.substring(index));
      return s2l.get(value);
    }
  }
  // end::answer[]
}
