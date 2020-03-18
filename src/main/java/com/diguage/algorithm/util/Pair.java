package com.diguage.algorithm.util;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-03-18 11:17
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
