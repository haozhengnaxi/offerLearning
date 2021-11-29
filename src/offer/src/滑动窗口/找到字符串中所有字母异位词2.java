package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/11/21 23:18
 * @Problem: 438. 找到字符串中所有字母异位词 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @Version 1.0
 *
 * 字典+滑窗，缩小每次计算量，重复利用之前的计算结果
 *
 */
public class 找到字符串中所有字母异位词2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int firstLen = s.length();
        int lastLen = p.length();
        int[] firstArr = new int[26];
        int[] lastArr = new int[26];
        if(lastLen > firstLen) {
            return list;
        }
        for(int i = 0; i < lastLen; i++) {
            firstArr[s.charAt(i) - 'a'] = firstArr[s.charAt(i) - 'a'] + 1;
            lastArr[p.charAt(i) - 'a'] = lastArr[p.charAt(i) - 'a'] + 1;
        }
        if(Arrays.equals(firstArr, lastArr)) {
            list.add(0);
        }
        for (int i = lastLen; i < firstLen; i++) {
            firstArr[s.charAt(i - lastLen) - 'a']--;
            firstArr[s.charAt(i) - 'a']++;
            if(Arrays.equals(firstArr, lastArr)) {
                list.add(i - lastLen + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        找到字符串中所有字母异位词2 test = new 找到字符串中所有字母异位词2();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
    }
}
