package 差分;

import java.util.*;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/6 23:30
 * @Problem: 179. 最大数 https://leetcode-cn.com/problems/largest-number/
 * @Version 1.0
 */
public class 最大数 {

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) != o2.charAt(0)) {
                    return o2.charAt(0) - o1.charAt(0);
                }
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : str) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        最大数 test = new 最大数();
        System.out.println(test.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }
}
