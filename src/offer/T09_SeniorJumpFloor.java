package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 22:16
 * @Version 1.0
 */
public class T09_SeniorJumpFloor{
    public static void main(String[]args) {
            T09_SeniorJumpFloor test = new T09_SeniorJumpFloor();

        }

    if (0 == target || 1 == target) {
        return 1;
        }
    else if (2 == target) {
        return 2;
        }
    // 这明显属于递归问题，可以先写出表达式，凑出递归式。根据递归式进行编程
    int sum = 0;
    for (int i = 1; i <= target; i++) {
        sum += T09_SeniorJumpFloor(target - i);
        }
    return sum;
}
