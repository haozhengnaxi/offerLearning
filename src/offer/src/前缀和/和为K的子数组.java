package 前缀和;

/**
 * @Author T.Y.Shang
 * @Date: 2021/8/5 23:19
 * @Problem:
 * @Version 1.0
 *
 * 560. 和为K的子数组  https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class 和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++)  {
            sum += nums[i];
            preSum[i] = sum;
        }
        int res = 0;
        for (int endIndex = 0; endIndex < len; endIndex++) {
            for(int startIndex = 0; startIndex < endIndex; startIndex++) {
                if(preSum[endIndex] - preSum[startIndex] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        和为K的子数组 test = new 和为K的子数组();
        System.out.println(test.subarraySum(new int[] {1, 1, 1}, 2));
        System.out.println(test.subarraySum(new int[] {1, 1, 1, 1}, 2));
        System.out.println(test.subarraySum(new int[] {1, 1, 1, 1, 1}, 0));
        System.out.println(test.subarraySum(new int[] {1, -1, 0}, 0));
    }
}
