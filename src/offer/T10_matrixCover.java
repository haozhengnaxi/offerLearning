package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 23:07
 * @Version 1.0
 */
public class T10_matrixCover (int target) {
    if (0 == target) {
        return 0;
        }
    if (1 == target) {
        return 1;
        }
    int[] array = new int[target+1];
    array[0] = 1;
    array[1] = 1;
    for (int i = 0; i < target; i++) {
        array[i] = array[i-1] + array[i-2];
        }
    return array[target];
}
