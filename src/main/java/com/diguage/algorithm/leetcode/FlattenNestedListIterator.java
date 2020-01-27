package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 341. Flatten Nested List Iterator
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator/[Flatten Nested List Iterator - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-27 15:17
 */
public class FlattenNestedListIterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * Runtime: 2 ms, faster than 99.89% of Java online submissions for Flatten Nested List Iterator.
     *
     * Memory Usage: 42.9 MB, less than 5.00% of Java online submissions for Flatten Nested List Iterator.
     */
    public class NestedIterator implements Iterator<Integer> {
        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            dfs(nestedList);
        }

        private void dfs(List<NestedInteger> nestedList) {
            if (Objects.isNull(nestedList) || nestedList.isEmpty()) {
                return;
            }

            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    queue.offer(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    private void test() {
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        FlattenNestedListIterator solution = new FlattenNestedListIterator();
        solution.test();
    }
}

