package 队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/9 23:54
 * @Problem: 402. 移掉K位数字  https://leetcode-cn.com/problems/remove-k-digits/
 * @Version 1.0
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";
        if(len == 1) return num;
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            char digit = num.charAt(i);
            // 保证队列中的数据单调递增即可
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            // 余位补充
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if(leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        移掉K位数字 test = new 移掉K位数字();
        String str = "1432219";
        int k = 4;
        test.removeKdigits(str, k);
    }
}
