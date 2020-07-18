package leetCode.DynamicPlan;

/**
 * @Author T.Y.Shang
 * @Date: 2020/7/13 21:58
 * @Problem:  斐波那契数列
 * @Version 1.0
 */
public class FibonacciNumber409 {
    public int fib(int N) {
        if (N < 2) return N;
        int[] res = new int[N+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[N];
    }

    public int fib2(int N) {
        if (N < 2) return N;
        int pre = 0;
        int cur = 1;
        int res = N;
        for (int i = 2; i <= N; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 8;
        FibonacciNumber409 test = new FibonacciNumber409();
//        int res = test.fib(N);
        int res = test.fib2(N);
        System.out.println(res);

    }
}
