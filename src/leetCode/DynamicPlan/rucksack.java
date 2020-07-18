package leetCode.DynamicPlan;


/**
 * @Author T.Y.Shang
 * @Date: 2020/7/15 23:30
 * @Problem:
 * @Version 1.0
 */
public class rucksack {
    // 每件物品只能选择一次   0-1背包
    public int rucksack1 (int W, int[] wt, int[] val) {
        int N = wt.length;
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N ; i++) {   // 物品数量
            for (int j = 1; j <= W; j++) {   //剩余空间 j
//                if (j < wt[i]) continue;
                if (j < wt[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + val[i-1]);
                }
            }
        }
//        return dp[N][W];
        int res = 0;
        System.out.println(N);
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                res = Math.max(res, dp[i][j]);
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return res;

    }
    // 0-1背包优化思路
    // 二维变一维，按行从最右侧取，即每次取最大的
    public int rucksack2 (int W, int[] wt, int[] val) {
        int[] dp2 = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int j = W; j >= wt[i]; j--) {
//            for (int j = wt[i]; j <= W; j++) {
                dp2[j] = Math.max(dp2[j], dp2[j - wt[i]] + val[i]);
            }
        }
        return dp2[W];
    }
    // 完全背包问题
    public int rucksack3 (int W, int[] wt, int[] val) {
        int len = wt.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < len; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
//        return dp[W + 1];
        int res = 0;
        for (int i = 0; i <= W; i++) {
            res = Math.max(res, dp[i]);
            System.out.print(res + "  ");
        }
        return res;
    }

    public static void main(String[] args) {
        int W = 10;     // 背包总容量
        int[] wt = {2, 2, 6, 5, 4};
        int[] val = {6, 3, 5, 4, 6};
        rucksack test = new rucksack();
//        int res = test.rucksack1(W, wt, val);
//        System.out.println(res);
//        int res2 = test.rucksack2(W, wt, val);
//        System.out.println(res2);
        int res3 = test.rucksack3(W, wt, val);
        System.out.println(res3);
    }
}
