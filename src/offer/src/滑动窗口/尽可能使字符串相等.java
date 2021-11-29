package 滑动窗口;

/**
 * 1208. 尽可能使字符串相等  https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 *
 *
 * @Author T.Y.Shang
 * @Date: 2021/8/3 23:25
 * @Problem:
 * @Version 1.0
 */
public class 尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int actualCost = Math.abs(s.charAt(0) - t.charAt(0));
        int startIndex = 0;
        int endIndex = 0;
        int res = 0;
        while (endIndex < s.length() && startIndex <= endIndex) {
            while (actualCost <= maxCost) {
                res = Math.max(res, endIndex - startIndex + 1);
                endIndex++;
                if(endIndex == s.length()) {
                    break;
                }
                actualCost += Math.abs(s.charAt(endIndex) - t.charAt(endIndex));
            }
            actualCost -= Math.abs(s.charAt(startIndex) - t.charAt(startIndex));
            startIndex++;
            if(startIndex > endIndex && endIndex < s.length() - 1) {
                endIndex++;
                actualCost += Math.abs(s.charAt(endIndex) - t.charAt(endIndex));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        尽可能使字符串相等 test = new 尽可能使字符串相等();

        System.out.println(test.equalSubstring("abcd", "bcdf", 3));  // 3
        System.out.println(test.equalSubstring("abcd", "cdef", 3));  // 1
        System.out.println(test.equalSubstring("abcd", "acde",  0)); // 1
        System.out.println(test.equalSubstring("abcd", "dcde",  10)); // 4

        System.out.println(test.equalSubstring("krrgw", "zjxss",  19)); // 2

        System.out.println(test.equalSubstring("anryddgaqpjdw", "zjhotgdlmadcf",  5));
    }
}
