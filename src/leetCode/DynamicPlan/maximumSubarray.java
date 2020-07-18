package leetCode.DynamicPlan;

/**
 * @Author T.Y.Shang
 * @Date: 2020/6/27 22:26
 * @Problem: LeetCode 最大子数组
 * @Version 1.0
 */

public class maximumSubarray {
    public int maxSubArrayByDP1(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        // 状态方程
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int maxSubArrayByDP2(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int dp0 = 0;
        int dp1 = nums[0];
        int res = dp1;
        for (int i = 1; i < len; i++) {
            // 状态方程
            dp0 = Math.max(nums[i], nums[i] + dp1);
            dp1 = dp0;
            //刷新后立刻比较
            res = Math.max(res, dp1);
        }
        return res;
    }

    public int maxSubArrayByDP3(int[] nums) {
        int res = nums[0];
        int sum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        maximumSubarray test = new maximumSubarray();
//        int result = test.maxSubArrayByDP1(nums);
        int result = test.maxSubArrayByDP2(nums);
//        int result = test.maxSubArrayByDP3(nums);
        System.out.println(result);
    }
}
