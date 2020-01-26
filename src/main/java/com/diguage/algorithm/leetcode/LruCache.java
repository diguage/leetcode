package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 146. LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/[LRU Cache - LeetCode]
 *
 * Design and implement a data structure for https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU[Least Recently Used (LRU) cache]. It should support the following operations: get and put.
 *
 * `get(key)` - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 * `put(key, value)` - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a *positive* capacity.
 *
 * *Follow up:*
 *
 * Could you do both operations in *O(1)* time complexity?
 *
 * .Example:
 * [source,java]
 * ----
 * LRUCache cache = new LRUCache(2);
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * ----
 *
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-26 10:49
 */
public class LruCache {
    /**
     * Runtime: 14 ms, faster than 90.57% of Java online submissions for LRU Cache.
     *
     * Memory Usage: 50.8 MB, less than 96.93% of Java online submissions for LRU Cache.
     *
     * Copy from: https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-ji-zhi-by-leetcode/[LRU 缓存机制 - LRU缓存机制 - 力扣（LeetCode）]
     */
    class LRUCache {
        private Map<Integer, DLinkedNode> data;
        private int capacity;
        private int size;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            this.data = new HashMap<>();
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();

            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public int get(int key) {
            DLinkedNode node = data.get(key);
            if (Objects.isNull(node)) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = data.get(key);
            if (Objects.isNull(node)) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                data.put(key, newNode);
                addNode(newNode);
                ++size;
                if (size > capacity) {
                    DLinkedNode tail = popTail();
                    data.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }
    }

    /**
     * Runtime: 22 ms, faster than 43.05% of Java online submissions for LRU Cache.
     *
     * Memory Usage: 58 MB, less than 51.53% of Java online submissions for LRU Cache.
     */
    class LRUCacheLinkedHashMap {
        private LinkedHashMap<Integer, Integer> data;

        public LRUCacheLinkedHashMap(int capacity) {
            data = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return this.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return data.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            data.put(key, value);
        }
    }

    private void test() {
        LRUCache solution = new LRUCache(2);
        solution.put(1, 1);
        solution.put(2, 2);
        int r1 = solution.get(1);
        System.out.println((r1 == 1) + " : " + r1);
        solution.put(3, 3);
        int r2 = solution.get(2);
        System.out.println((r2 == -1) + " : " + r2);
        solution.put(4, 4);
        int r3 = solution.get(1);
        System.out.println((r3 == -1) + " : " + r3);
        int r4 = solution.get(3);
        System.out.println((r4 == 3) + " : " + r4);
        int r5 = solution.get(4);
        System.out.println((r5 == 4) + " : " + r5);
    }

    public static void main(String[] args) {
        LruCache solution = new LruCache();
        solution.test();
    }
}
