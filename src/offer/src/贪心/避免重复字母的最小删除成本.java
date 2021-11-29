package 贪心;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/9 21:29
 * @Problem: 1578 避免重复字母的最小删除成本 https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * @Version 1.0
 */
public class 避免重复字母的最小删除成本 {
    public int minCost(String s, int[] cost) {
        int res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                res += Math.min(cost[i], cost[i - 1]);
                cost[i] = Math.max(cost[i], cost[i - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "bbbaaa";
        int[] cost = {4,9,3,8,8,9};
        避免重复字母的最小删除成本 test = new 避免重复字母的最小删除成本();
        int res = test.minCost(str, cost);
        System.out.println(res);
    }
}
