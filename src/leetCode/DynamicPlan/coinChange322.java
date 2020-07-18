package leetCode.DynamicPlan;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author T.Y.Shang
 * @Date: 2020/7/14 21:31
 * @Problem:  零钱兑换 medium
 * @Version 1.0
 */
public class coinChange322 {
//    动态规划，从下到上
    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        int len = coins.length;
        int[] dp = new int [amount + 1];
        /*
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }*/
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < len; i++) {
                if (j < coins[i]) continue;
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    public int coinChange2(int[] coins, int amount) {

    }

    public static void main(String[] args) {
        int[] coin = {1,2,5};
        int amount = 11;
        coinChange322 test = new coinChange322();
//        int res = test.coinChange1(coin, amount);
        int res = test.coinChange2(coin, amount);
        System.out.println(res);
    }
}
