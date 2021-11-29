package 贪心;

/**
 * @Author T.Y.Shang
 * @Date: 2021/4/26 23:58
 * @Problem:
 * @Version 1.0
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            // 定义i 为起点
            res = canCompleteCircuitByStart(gas, cost, i);
            if(res != -1) {
                return res;
            }
        }
        return res;
    }

    public int canCompleteCircuitByStart(int[] gas, int[] cost, int K) {
        int len = gas.length;
        int leftGas = gas[K];
        int i = K;
        int costGas;
        for (; i < K + len; i++) {
            int tmp = i;
            if(tmp >= len) {
                tmp = i - len;
            }
            // 走到下一站耗油量
            costGas = cost[tmp];
            if (leftGas < costGas) {
                return -1;
            }
            // 在下一站加油
            if (tmp + 1 >= len) {
                tmp = tmp - len;
            }
            leftGas += - costGas + gas[tmp + 1];
        }
        if (leftGas >= 0) {
            return K;
        }
        return -1;
    }

    public static void main(String[] args) {
        加油站 test = new 加油站();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int result = test.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
