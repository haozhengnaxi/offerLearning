package leetCode.Stack;

import java.util.Stack;

/**
 * @Author T.Y.Shang
 * @Date: 2020/6/30 23:29
 * @Problem: 用栈实现队列
 * @Version 1.0
 */
public class RealizeStackByQuene {

    Stack<int> s1, s2;
    private int front;
    /** Initialize your data structure here. */
    public RealizeStackByQuene() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        s1.pop();
        if (s1.empty()) {
            front = s1.peek();
        }
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        RealizeStackByQuene obj = new RealizeStackByQuene();
        int x = 2;
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}
