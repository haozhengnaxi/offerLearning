package 差分;

import java.util.HashMap;

/**
 * @Author T.Y.Shang
 * @Date: 2021/8/23 23:57
 * @Problem: 1094. 拼车  https://leetcode-cn.com/problems/car-pooling/
 * @Version 1.0
 */
public class 拼车 {

    public boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;
//        K - 位置， V - 剩余容量
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftCapacity = capacity;
        for (int i = 0; i < len; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                map.put(j, map.getOrDefault(j, leftCapacity) - trips[i][0]);
                if(map.get(j) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        拼车 test = new 拼车();
        System.out.println(test.carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(test.carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println(test.carPooling(new int[][] {{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println(test.carPooling(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
    }
}
