package 滑动窗口;

import java.util.*;

/**
 * @Author T.Y.Shang
 * @Date: 2021/11/21 11:21
 * @Problem: 3. 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Version 1.0
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        int len = s.length();
        // K - 字符， V - 该字符的最新的位置
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int begin = 0;
        int end = 0;
        int res = 0;
        for(int i = 1; i < len; i++) {
            if(map.containsKey(s.charAt(i))) {
                // 当出现重复的字符时，连续性断了，begin应从新的重复字母开始
//                begin = map.get(s.charAt(i)) + 1;  // 这样会出现begin倒退的情况，故应取个较大值
                begin = Math.max(begin, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            end = i;
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        无重复字符的最长子串 test = new 无重复字符的最长子串();
//        System.out.println(test.lengthOfLongestSubstring("abcabcbb")); // abc
//        System.out.println(test.lengthOfLongestSubstring("bbbbb")); // b
//        System.out.println(test.lengthOfLongestSubstring("pwwkew")); // wke
        System.out.println(test.lengthOfLongestSubstring("wwpkpew")); // kpew
    }
}
