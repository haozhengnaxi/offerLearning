package 滑动窗口;

import java.util.*;

/**
 * @Author T.Y.Shang
 * @Date: 2021/11/21 20:50
 * @Problem: 438. 找到字符串中所有字母异位词 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @Version 1.0
 *
 * 并没有AC，实际只AC一半
 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int firstLen = s.length();
        int lastLen = p.length();
        TreeMap<Character, Integer> firstMap = new TreeMap<>();
        TreeMap<Character, Integer> lastMap = new TreeMap<>();
        lastMap = mapString(p);
        for(int i = 0; i <= (firstLen - lastLen); i++) {
            String str = s.substring(i, i + lastLen);
            firstMap = mapString(str);
            if(lastMap.equals(firstMap)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 纯暴力解法
     * @param str
     * @return
     */
    public String sortString(String str) {
        int len = str.length();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            list.add(str.charAt(i));
        }
        Collections.sort(list);
        return list.toString();
    }

    /**
     * 利用treeMap的去重特性，比暴力多了三个用例
     * @param str
     * @return
     */
    public TreeMap<Character, Integer> mapString(String str) {
        int len = str.length();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < len; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        找到字符串中所有字母异位词 test = new 找到字符串中所有字母异位词();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
    }
}
