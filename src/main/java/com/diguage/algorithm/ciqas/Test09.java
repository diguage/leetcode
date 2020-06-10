package com.diguage.algorithm.ciqas;

import java.util.Stack;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 21:15
 */
public class Test09 {
    class CQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;

        public CQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (!out.empty()) {
                return out.pop();
            }
            while (!in.empty()) {
                out.push(in.pop());
            }
            if (out.isEmpty()) {
                return -1;
            } else {
                return out.pop();
            }
        }
    }

    public void test() {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    public static void main(String[] args) {
        Test09 solution = new Test09();
        solution.test();
    }
}
