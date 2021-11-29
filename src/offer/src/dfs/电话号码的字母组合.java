package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/2 23:33
 * @Problem:
 * @Version 1.0
 */
public class 电话号码的字母组合 {
    String[] array = {"", "", "abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<String>();
    StringBuilder str = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        int length = digits.length();
        dfs(digits, str, 0);
        return res;
    }

    public void dfs(String digits, StringBuilder string, int stringIndex) {
        if (digits.length() == stringIndex) {
            res.add(string.toString());
            return;
        }
        int n = digits.charAt(stringIndex) - '0';
        String str = array[n];
        for(int i = 0; i < str.length(); i++) {
            dfs(digits, string.append(str.charAt(i)), stringIndex + 1);
            string.deleteCharAt(string.toString().length() - 1);
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合 test = new 电话号码的字母组合();
        String digits = "234";
        List<String> res = test.letterCombinations(digits);
        System.out.println(res);
    }
}
