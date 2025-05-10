package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0705_DesignHashset {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-10 19:50:48
   */
  class MyHashSet {
    private int[] data;
    private int mask;
    private int size;

    public MyHashSet() {
      data = new int[8];
      Arrays.fill(data, -1);
      mask = 8 - 1;
      size = 0;
    }

    public void add(int key) {
      if (size >= data.length * 3 / 4) {
        resize(data.length * 2);
      }
      boolean result = add(data, key, mask);
      if (result) {
        size++;
      }
    }

    public void remove(int key) {
      int index = key & mask;
      boolean ok = false;
      for (int i = index; i < data.length; i++) {
        if (data[i] == key) {
          data[i] = -1;
          ok = true;
        }
      }
      if (!ok) {
        for (int i = 0; i < index; i++) {
          if (data[i] == key) {
            data[i] = -1;
            ok = true;
          }
        }
      }
      if (ok) {
        size--;
      }
      // 需要考虑在初始化时，没有值的情况的缩容问题
      if (size <= data.length / 3 && data.length > 8) {
        resize(data.length / 2);
      }
    }

    public boolean contains(int key) {
      int index = key & mask;
      for (int i = index; i < data.length; i++) {
        if (data[i] == key) {
          return true;
        }
      }
      for (int i = 0; i < index; i++) {
        if (data[i] == key) {
          return true;
        }
      }
      return false;
    }

    private void resize(int length) {
      int[] newData = new int[length];
      Arrays.fill(newData, -1);
      int newMask = length - 1;
      for (int k : data) {
        if (k == -1) {
          continue;
        }
        add(newData, k, newMask);
      }
      this.data = newData;
      this.mask = newMask;
    }

    private boolean add(int[] data, int key, int newMask) {
      int index = key & newMask;
      if (data[index] == -1) {
        data[index] = key;
        return true;
      } else if (data[index] == key) {
        return false;
      } else {
        // 使用开放地址法解决哈希冲突
        for (int j = index + 1; j < data.length; j++) {
          if (data[j] == -1) {
            data[j] = key;
            return true;
          } else if (data[j] == key) {
            return false;
          }
        }
        for (int j = 0; j < index; j++) {
          if (data[j] == -1) {
            data[j] = key;
            return true;
          } else if (data[j] == key) {
            return false;
          }
        }
      }
      return false;
    }
  }
  // end::answer[]
}
