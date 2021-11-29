/**
 * @Author T.Y.Shang
 * @Date: 2021/4/7 22:44
 * @Problem:
 * @Version 1.0
 */
public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 0;
        int currDiff;
        int preDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            /**
             * 实际操作上，其实连删除的操作都不用做，因为题目要求的是最长摆动子序列的长度，
             * 所以只需要统计数组的峰值数量就可以了（相当于是删除单一坡度上的节点，然后统计长度）
             */
            if ((currDiff > 0 && preDiff <= 0) || (currDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = currDiff;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        摆动序列 test = new 摆动序列();
        int[] nums = {1,1,1,1};
        int result = test.wiggleMaxLength(nums);
        System.out.println(result);
    }
}
