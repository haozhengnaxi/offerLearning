/**
 * @Author T.Y.Shang
 * @Date: 2020/3/3 22:01
 * @Version 1.0
 */
public class T06_minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return ;
        int high = array.length - 1;
        int low = 0;
        int mid = 0;
        while (high > low) {
            mid = (high + low) / 2;
            if (array[mid] > array[high]) {
                //使用low=mid+1，而不是low=mid，最终会使得low=high（即最小值位置）而跳出循环；
                low = mid + 1;
            }
            else if (array[mid] < array[high]) {
                //使用high=mid，而不是high=mid-1，因为有可能mid就是最小值点，不能减1；
                high = mid;
            }
            else
                high = high - 1;
        }
        return array[low];
    }
}
