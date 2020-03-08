package offer;

import java.util.Stack;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 20:37
 * @Version 1.0
 */
public class T5_twoPushToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();// stack1入栈时使用
    Stack<Integer> stack2 = new Stack<Integer>();// stack2出栈时使用，直接出栈即可。

    public void push(int node) {
        // 最开始，要保证stack2中没有值
        // 如果方法在push值时stack2中有值，则从stack1中的值会先pop出来，顺序会错
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        // 先将当前要进入队列的值放入stack1中
        stack1.push(node);
        // 将stack1中的值全部放到stack2中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
