import java.util.Arrays;

/**
 * @Author T.Y.Shang
 * @Date: 2021/4/24 23:33
 * @Problem: 1005. K 次取反后最大化的数组和 https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * @Version 1.0
 */
public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] arrayTmp = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        // 负数足够多
        for (int i = 0; i < A.length && K > 0; i++) {
            if(A[i] <= 0) {
                 A[i] = 0 - A[i];
                 K--;
            }
        }
        while (K-- > 0) {
            Arrays.sort(A);
            A[0] = 0 - A[0];
        }
        return sumArray(A);
    }

    public int sumArray(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        K次取反后最大化的数组和 test = new K次取反后最大化的数组和();
        int[] A = {2,-3,-1,5,-4};
        int K = 2;
        int result = test.largestSumAfterKNegations(A, K);
        System.out.println(result);
    }
}
