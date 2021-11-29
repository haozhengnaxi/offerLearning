package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/22 21:25
 * @Version 1.0
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length - 1;
        while (k > 0) {
            int tmp = nums[len];
            for (int i = 0; i < len; i++) {
                nums[len - i] = nums[len - i - 1];
            }
            nums[0] = tmp;
            k--;
        }
        for (int a : nums) {
            System.out.println(a);
        }
    }
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 1) return a;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int left = 1;
            int right = 1;
            for (int j = 0; j < i; j++) {
                left = left * a[j];
            }
            for (int k = i + 1; k < len; k++) {
                right = right * a[k];
            }
            result[i] = left * right;
        }
        for (int aa : result) {
            System.out.println(aa);
        }
        return result;
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num1;
        if (num2 == null || num2.length() == 0) return num2;
        StringBuilder sb = new StringBuilder ("");
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int flag = 0;
        int i = num1.charAt(len1) - '0';
        int j = num2.charAt(len2) - '0';
        while (len1 >= 0 || len2 >= 0) {
            int tmp = ((len1 >= 0) ?  (num1.charAt(len1) - '0') : 0) + (( len2 >= 0) ?  (num2.charAt(len2) - '0') : 0 ) + flag;
            if (tmp >= 10) {
                tmp = tmp % 10;
                flag = 1;
            }
            sb.append(tmp);
            len1-- ;
            len2--;
        }
//        return sb.reverse().toString();
        return sb.toString();
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) return null;
        int len = s.length();
        if (n > len) return null;
        String tmp = s.substring(0, n - 1);
        StringBuilder sb = new StringBuilder("");
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i+1));
        }
        sb.append(tmp);
        return sb.toString();
    }

    public String sortString(String s) {
        if (s.length() == 0) return s;
        int[] array = new int[52];
        int len = s.length() - 1;
        // a 4  b 4  c 4 d 4
        while (len >= 0) {
            int i = 1;
            int num = s.charAt(len) - 'a';
            array[num * 2] = s.charAt(len);
            array[num*2 + 1] = ++array[num*2 + 1];
            len--;
        }
        StringBuilder sb = new StringBuilder("");
        int max = 0;
        for (int j = 0; j < 26; j++) {
            max = Math.max(max, array[j * 2 + 1]);
        }
        for (int n = 0; n < max; n++) {
            // 从小到大输出
            for (int j = 0; j < 25; j++) {
                if (array[2 * j + 1] != 0) {
                    sb.append(array[j * 2]);
                    array[j * 2 + 1] = array[j * 2 + 1] - 1;
                }
            }
            // 从大到小输出
            for (int k = 25; k >= 0; k--) {
                if (array[k * 2 + 1] != 0) {
                    sb.append(array[k * 2]);
                    array[k * 2 + 1] -= 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[5];
        int i = 0;
        while ( i < nums.length) {
            nums[i] = i+1;
            i ++;
        }
//        test.rotate(nums,3);
//        test.constructArr(nums);
//        String s = test.addStrings("12121","989899");
//        System.out.println(s);
//        String ss = test.reverseLeftWords("absdfadfaadf",3);
//        System.out.println(ss);
        String s = "rat";
        String ss = test.sortString(s);
//        System.out.println(ss);

        int a = 1;
        double b = 1.32232;
        System.out.println(a + b);
    }

}
