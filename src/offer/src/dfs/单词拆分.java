package dfs;

import java.util.Arrays;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/14 21:59
 * @Problem:
 * 19/35   DP算法适合，
 * @Version 1.0
 */
public class 单词拆分 {
    private boolean res;

    public boolean wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict, 0, 0);
        return res;
    }

    public void dfs(String s, List<String> wordDict, int level, int count) {
        // 递归终止条件
        if(level >= wordDict.size() || s.length() == 0) {
            if(count == wordDict.size()) {
                res = true;
                return;
            }
            if(res != true) {
                res = false;
            }
            return;
        }
        for(int i = level; i < wordDict.size(); i++) {
            String str = s;
            if(!s.contains(wordDict.get(i))) {
                res = false;
                return;
            }
            // 单层逻辑
            int index = s.indexOf(wordDict.get(i));
            s = str.substring(0, index) + str.substring(index + wordDict.get(i).length());
            // 执行递归
            dfs(s, wordDict, i + 1, count + 1);
            // 恢复现场
            s = str;
        }
    }

    public static void main(String[] args) {
        单词拆分 test = new 单词拆分();
//        String str = "LeetCode";
//        String[] arr = {"Leet", "Code"};
//        String str = "applepenapple";
//        String[] arr = {"apple", "pen"};
        String str = "catsandog";
        String[] arr = {"cats", "dog", "sand", "and", "cat"};
        List<String> list = Arrays.asList(arr);
        System.out.println(test.wordBreak(str, list));

    }
}
