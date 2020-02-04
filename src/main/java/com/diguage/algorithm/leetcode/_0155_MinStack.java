package com.diguage.algorithm.leetcode;

import java.util.Stack;

/**
 * = 155. Min Stack
 *
 * https://leetcode.com/problems/min-stack/[Min Stack - LeetCode]
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * * push(x) -- Push element x onto stack.
 * * pop() -- Removes the element on top of the stack.
 * * top() -- Get the top element.
 * * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * .Example:
 * [source]
 * ----
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-24 16:40
 */
class _0155_MinStack {

    // Runtime: 8 ms, faster than 18.94% of Java online submissions for Min Stack.
    // Memory Usage: 46.2 MB, less than 5.08% of Java online submissions for Min Stack.
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public _0155_MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty() || x < helper.peek()) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }

//    Runtime: 10 ms, faster than 14.80% of Java online submissions for Min Stack.
//    Memory Usage: 46.6 MB, less than 5.08% of Java online submissions for Min Stack.
//    private Stack<Integer> stack;
//    private PriorityQueue<Integer> queue;
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        stack = new Stack<>();
//        queue = new PriorityQueue<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        queue.add(x);
//    }
//
//    public void pop() {
//        Integer value = stack.pop();
//        queue.remove(value);
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return queue.peek();
//    }

    public static void main(String[] args) {
        _0155_MinStack solution = new _0155_MinStack();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        System.out.println(solution.getMin()); // -3
        solution.pop();
        System.out.println(solution.top()); // 0
        System.out.println(solution.getMin()); // -2
    }
}


