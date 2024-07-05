package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 380. Insert Delete GetRandom O(1)
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/[Insert Delete GetRandom O(1) - LeetCode]
 *
 * Design a data structure that supports all following operations in average *O(1)* time.
 *
 * . `insert(val)`: Inserts an item val to the set if not already present.
 * . `remove(val)`: Removes an item val from the set if present.
 * . `getRandom`: Returns a random element from current set of elements. Each element must have the *same probability* of being returned.
 *
 * .Example:
 * [source]
 * ----
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-05 16:44:29
 */
public class _0380_InsertDeleteGetRandomO1_2 {
  /**
   * 自己实现
   */
  class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> idex;
    private Random random;

    public RandomizedSet() {
      nums = new ArrayList<>();
      random = new Random();
      idex = new HashMap<>();
    }

    public boolean insert(int val) {
      if (idex.containsKey(val)) {
        return false;
      } else {
        nums.add(val);
        idex.put(val, nums.size() - 1);
        return true;
      }
    }

    public boolean remove(int val) {
      if (!idex.containsKey(val)) {
        return false;
      } else {
        int i1 = idex.get(val);
        if (i1 != idex.size() - 1) {
          Integer value = nums.get(nums.size() - 1);
          nums.set(i1, value);
          idex.put(value, i1);
        }
        idex.remove(val);
        nums.remove(nums.size() - 1);
        return true;
      }
    }

    public int getRandom() {
      return nums.get(random.nextInt(nums.size()));
    }
  }
}
