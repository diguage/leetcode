package com.diguage.algo.leetcode;

import java.util.Iterator;

public class _0284_PeekingIterator {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-08 19:40:07
   */
  class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer header;

    public PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if (header == null) {
        if (iterator.hasNext()) {
          header = iterator.next();
          return header;
        } else {
          return null;
        }
      } else {
        return header;
      }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      if (header == null) {
        if (iterator.hasNext()) {
          return this.iterator.next();
        } else {
          return null;
        }
      } else {
        Integer result = header;
        header = null;
        return result;
      }
    }

    @Override
    public boolean hasNext() {
      if (header == null) {
        return this.iterator.hasNext();
      } else {
        return true;
      }
    }
  }
  // end::answer[]
}
