package 回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/6/16 23:08
 * @Problem: 93. 复原 IP 地址 https://leetcode-cn.com/problems/restore-ip-addresses/
 * @Version 1.0
 */
public class 复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if(s.length() < 4) {
            return res;
        }
        String[] arr = new String[4];
        backPath(res,"", s , 0, 0, arr);
        return res;
    }

    //
    public void backPath(List<String> res, String currString, String sourceString, int level, int offset, String[] arr) {
        // 递归终止条件
        if (level > 3) {
            if(offset < sourceString.length() - 1) {
                return;
            }
            if (validIsIP(currString)) {
                res.add(dispatchArray(arr));
                return;
            }
        }
        // 递归
        // offset 记录从源串中取值的起点
        // i 下一次取值的长度
        int i = offset;
        for(; i < offset + 3 && i < sourceString.length(); i++) {
            currString = sourceString.substring(offset, i + 1);
            System.out.println(currString);
            if(validIsIP(currString)) {
                arr[i] = currString;
                backPath(res, currString, sourceString, level + 1, i + 1, arr);
                arr[i] = "";
            }
        }
    }

    // 判断当前字符串是否符合IP特性
    public boolean validIsIP(String str) {
        if (str.length() == 0 || str.length() > 3 || Integer.parseInt(str) > 255 || Integer.parseInt(str) < 1) {
            return false;
        }
        return true;
    }

    public String dispatchArray(String[] arr) {
        int len = arr.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(arr[i]).append(".") ;
        }
        return str.toString().substring(0, str.toString().length() - 1);
    }

    public static void main(String[] args) {
        复原IP地址 test = new 复原IP地址();
        String s = "25525511135";
        List<String> res = test.restoreIpAddresses(s);
        System.out.println(res);
    }
}
