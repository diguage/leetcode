package com.diguage.algo.leetcode;

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
 * @since 2020-01-05 23:47
 */
public class _0380_InsertDeleteGetRandomO1 {
  // tag::answer[]
  // end::answer[]


    public static void main(String[] args) {
        RandomizedSet solution = new RandomizedSet();
        solution.insert(3);
        solution.insert(3);
        solution.insert(1);
        solution.remove(3);
        int random = solution.getRandom();
        System.out.println(random);
    }

    /**
     * Runtime: 12 ms, faster than 47.51% of Java online submissions for Insert Delete GetRandom O(1).
     *
     * Memory Usage: 44 MB, less than 96.00% of Java online submissions for Insert Delete GetRandom O(1).
     *
     * Copy from: https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/[Insert Delete GetRandom O(1) - LeetCode]
     */
    static
    class RandomizedSet {

        private List<Integer> nums;
        private Map<Integer, Integer> numToIndexMap;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<>();
            numToIndexMap = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (numToIndexMap.containsKey(val)) {
                return false;
            }
            numToIndexMap.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!numToIndexMap.containsKey(val)) {
                return false;
            }
            Integer index = numToIndexMap.get(val);
            if (index < nums.size() - 1) {
                Integer lastNum = nums.get(nums.size() - 1);
                nums.set(index, lastNum);
                numToIndexMap.put(lastNum, index);
            }
            numToIndexMap.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            return nums.get(random.nextInt(nums.size()));
        }
    }
}



/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
