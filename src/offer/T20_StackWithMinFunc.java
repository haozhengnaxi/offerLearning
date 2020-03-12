package offer;

import java.util.Stack;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/12 23:04
 * @Version 1.0
 */
public class T20_StackWithMinFunc {
    // 先定义一个辅助栈临时存储数据
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int minValue = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if (minValue > node) {
            minValue = node;
        }
        minStack.push(minValue);
    }
    public void pop() {
        stack.pop();
        minStack.pop();
        // peek()和top()均返回栈顶的值，但是peek不删除栈顶的值，top会删除
        minValue = minStack.peek();
    }
    public int top() {
        return minStack.peek();
    }
    public int min() {
        return minValue;
    }
}
