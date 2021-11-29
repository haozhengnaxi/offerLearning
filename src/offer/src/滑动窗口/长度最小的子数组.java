package 滑动窗口;

/**
 * 209. 长度最小的子数组https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 *
 *
 * @Author T.Y.Shang
 * @Date: 2021/8/2 23:27
 * @Problem:
 * @Version 1.0
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int existFlag = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum < target) {
                    if (j == nums.length - 1) {
                        sum = 0;
                        break;
                    }
                    continue;
                } else {
                    len = Math.min(len, j - i + 1);
                    sum = 0;
                    existFlag = 1;
                    break;
                }
            }
        }
        return existFlag == 0 ? 0 : len;
    }

    public static void main(String[] args) {
        长度最小的子数组 test = new 长度最小的子数组();
//        System.out.println(test.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
//        System.out.println(test.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(test.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
//        test.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3});
    }
}
