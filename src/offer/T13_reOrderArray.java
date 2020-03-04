package offer;

import static java.lang.System.out;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/4 21:32
 * @Version 1.0
 */
public class T13_reOrderArray {
    public void reOrderArray (int [] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int odd = 0;
        int even = 0;
        int len = array.length;
        while (even < len && odd < len) {
            // 先找到第一个偶数even
            while (even < len && array[even] % 2 != 0)
                even ++;
            odd = even + 1;
            while ( odd < len && array[odd] % 2 == 0 )
                odd ++;
            if (odd >= len)
                break;
            int tmp = array[odd];
            for (int i = odd; i > even; i--) {
                array[i] = array[i-1];
            }
            array[even] = tmp;
            even ++;
        }
    }
    public static void main(String[] args) {
        T13_reOrderArray test = new T13_reOrderArray();
        int [] a;
        a = new int[] { 0, 2, 1, 4, 3, 5};
        test.reOrderArray(a);
        for (int i= 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
