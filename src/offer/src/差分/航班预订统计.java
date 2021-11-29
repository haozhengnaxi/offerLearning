package 差分;

import java.util.*;

/**
 * @Author T.Y.Shang
 * @Date: 2021/8/24 0:08
 * 差分 ———— 未完成 43/64 超时
 * @Problem: 1109. 航班预订统计 https://leetcode-cn.com/problems/corporate-flight-bookings/
 * @Version 1.0
 */
public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int size = bookings.length;
        // K - 航班编号  V — 座位数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < size; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                treeMap.put(j, bookings[i][2] + treeMap.getOrDefault(j, 0));
                res[j - 1] = treeMap.get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        航班预订统计 test = new 航班预订统计();
        test.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2);
        test.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20},{2, 5, 25}}, 5);
        test.corpFlightBookings(new int[][]{{2, 2, 30}, {2, 2, 45}}, 2);
    }
}
