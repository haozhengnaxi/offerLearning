package 设计题.排序总结;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/5 21:52
 * @Problem:
 * @Version 1.0
 */
public class 一维数组排序 {
    public void sortOneDimArrayAsc(Integer[] array) {
        Arrays.sort(array);
    }

    public void sortOneDimArrayDesc(Integer[] array) {
        // 先升序
        Arrays.sort(array);
        // 转为list
        List<Integer> list = Arrays.asList(array);
        // 利用list的逆转，值引用原array也实现了降序
        Collections.reverse(list);
    }

    public void sortOneDimArrayDesc2(Integer[] array) {
        // 使用Comparator时，入参必须时包装类
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return 0 - o1.compareTo(o2);
            }
        });
    }

    public static void main(String[] args) {
        一维数组排序 test = new 一维数组排序();
        Integer[] array = {2, 10, 5, 9, 1, 7};
        test.sortOneDimArrayAsc(array);
        test.sortOneDimArrayDesc(array);
        test.sortOneDimArrayDesc2(array);
    }
}
