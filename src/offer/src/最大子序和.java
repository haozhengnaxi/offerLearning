/**
 * @Author T.Y.Shang
 * @Date: 2021/4/7 23:14
 * @Problem: 53. 最大子序和  https://leetcode-cn.com/problems/maximum-subarray/
 * @Version 1.0
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (tmp > result) {
                result = tmp;
            }
            // 如果相加之和为负值，这部分数据就应该舍去，临时变量设置为0，
            if (tmp < 0) {
                tmp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        最大子序和 test = new 最大子序和();
        int[] nums = {5, 4, -1, 7, 8};
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = test.maxSubArray(nums);
        System.out.println(result);
    }
}
