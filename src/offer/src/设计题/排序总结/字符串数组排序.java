package 设计题.排序总结;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/5 23:25
 * @Problem:
 * @Version 1.0
 */
public class 字符串数组排序 {
    public void sortStringArrayAsc(String[] string) {
        // 字符串数组，属于数组类型，按照数组类型排序即可
        Arrays.sort(string);
    }

    public static void main(String[] args) {
        字符串数组排序 test = new 字符串数组排序();
        String[] str = {"hello","world","!"};
        test.sortStringArrayAsc(str);
    }
}
