import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/2 23:57
 * @Problem:
 * @Version 1.0
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        dfs(n, res, str, 0, 0);
        return res;
    }
    public void dfs(int n, List<String> res, String str, int open, int close) {
        if (open > n || close > open) return;
        if(str != null && str.length() == n * 2) {
            res.add(str);
            return;
        }
        dfs(n, res, str + "(", open + 1, close);
        dfs(n, res, str + ")", open, close + 1);
    }

    /**
     * 我的 解法
     * @param n input
     * @return 结果
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 使用LeetCode上的解法的时候，不能使用SB方法，剪枝时存在问题。
        StringBuilder str = new StringBuilder();
        dfs2(n, res, str, 0, 0);
        return res;
    }
    public void dfs2(int n, List<String> res, StringBuilder str, int open, int close) {
        if (open > n || close > open) return;
        if(str != null && str.length() == n * 2) {
            res.add(str.toString());
            return;
        }
        if(open < n) {
            dfs2(n, res, str.append("("), open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }
        if(close < n) {
            dfs2(n, res, str.append(")"), open, close + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        括号生成 test = new 括号生成();
        System.out.println(test.generateParenthesis(2));
    }
}
