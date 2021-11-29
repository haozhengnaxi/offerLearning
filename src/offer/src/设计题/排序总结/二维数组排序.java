package 设计题.排序总结;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/5 22:39
 * @Problem:
 * @Version 1.0
 */
public class 二维数组排序 {
    public void sortTwoDimArrayAsc(Integer[][] array) {
        // 二维数组排序必须指定按某一列进行排序
        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[2].compareTo(o2[2]);
            }
        });
    }

    public  void sortTwoDimArrayDesc(Integer[][] array) {
        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return 0 - o1[1].compareTo(o2[1]);
            }
        });
    }

    public static void main(String[] args) {
        二维数组排序 test = new 二维数组排序();
        Integer[][] array = {{1, 3, 2},{9, 11, 7},{20, 12, 19}};
        test.sortTwoDimArrayAsc(array);
        test.sortTwoDimArrayDesc(array);
    }
}
