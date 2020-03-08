package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 23:27
 * @Version 1.0
 */
public class T11_numberOf_1_InBinaryNumber {
    int count = 0;
        while (n != 0) {
        n = n & (n - 1);
        count++;
    }
        return count;
}
