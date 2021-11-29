package 字符串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author T.Y.Shang
 * @Date: 2021/8/2 23:25
 * @Problem: 227. 基本计算器 II https://leetcode-cn.com/problems/basic-calculator-ii/
 * @Version 1.0
 */
public class 基本计算器II {
    public int calculate(String s) {
        int res = 0;
        if(s.length() == 0) {
            return res;
        }
        // 字符串预处理
        String strWithoutBlank = "";
        strWithoutBlank = s.replace(" ", "");
        int len = strWithoutBlank.length();
        String str = "";
        for (int i = 0; i < len; i++) {
            if(strWithoutBlank.charAt(i) > 46 && strWithoutBlank.charAt(i) < 58) {
                str = strWithoutBlank.substring(i, len);
                break;
            }
        }
        Deque stack = new LinkedList();
        calMethod(str, 0, stack);
        res = getResult(stack);
        return res;
    }

    public void calMethod(String s, int startIndex, Deque stack) {
        int sum = stack.isEmpty() == true ? 0 : Integer.parseInt(stack.getLast().toString());
        // 每次递归处理数据
        for(int i = startIndex; i < s.length(); i++) {
            int nextIndex = getNextIndex(s, i);
            if(s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
                // 假设数字都是个位数  s.charAt(i + 1)
                stack.push(s.substring(i, nextIndex));
                i = nextIndex - 1;
            } else if(s.charAt(nextIndex) == '+') {
                int next = getNextIndex(s, nextIndex + 1);
                stack.push(s.substring(nextIndex + 1, next));
                i = next - 1;
            } else if (s.charAt(i) == '-') {
                int next = getNextIndex(s, nextIndex + 1);
                stack.push(0 - Integer.parseInt(s.substring(nextIndex + 1, next)));
                i = next - 1;
            } else if (s.charAt(i) == '*') {
                int tmp = Integer.parseInt(stack.getFirst().toString());
                stack.pop();
                int next = getNextIndex(s, nextIndex + 1);
                stack.push(tmp * Integer.parseInt(s.substring(nextIndex + 1, next)));
                i = next - 1;
            } else {
                int tmp = Integer.parseInt(stack.getFirst().toString());
                stack.pop();
                int next = getNextIndex(s, nextIndex + 1);
                stack.push(tmp / Integer.parseInt(s.substring(nextIndex + 1, next)));
                i = next - 1;
            }
        }
    }

    public int getNextIndex(String s, int startIndex) {
        int nextIndex = startIndex;
        while (nextIndex < s.length() && s.charAt(nextIndex) > 47 && s.charAt(nextIndex) < 58) {
            nextIndex++;
        }
        return nextIndex;
    }

    public int getResult(Deque queue) {
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += Integer.parseInt(queue.getFirst().toString());
            queue.pop();
        }
        return sum;
    }
}
