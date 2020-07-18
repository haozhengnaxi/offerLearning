package leetCode.DynamicPlan;

/**
 * @Author T.Y.Shang
 * @Date: 2020/6/29 23:58
 * @Problem: Leetcode 最长连续递增序列
 * @Version 1.0
 */
public class LongestConIncreasSubSeq674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i< len; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,5,4,7,9,1,10};
        LongestConIncreasSubSeq674 test = new LongestConIncreasSubSeq674();
        int result = test.findLengthOfLCIS(nums);
        System.out.println(result);
    }
}
