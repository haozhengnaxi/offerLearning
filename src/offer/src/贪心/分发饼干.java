package 贪心;

import java.util.Arrays;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/9 0:14
 * @Problem: 455 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 * @Version 1.0
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for(int i = 0; i < s.length && res < g.length; i++) {
            if (g[res] <= s[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        分发饼干 test = new 分发饼干();
        // g 代表胃口值
        int[] g = {1, 2};
        // s 代表饼干尺寸
        int[] s = {1, 2, 3};
        int count = test.findContentChildren(g, s);
        System.out.println(count);
    }
}
