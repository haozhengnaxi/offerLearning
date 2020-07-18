package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 21:29
 * @Version 1.0
 */
public class T08_jumpFloor () {
    public int jumpFloor(int target) {
        if (0 == target) {
        return 0;
        }
        else if (target == 1) {
        return 1;
        }
        else if (target == 2) {
        return 2;
        }
        else if (target > 2) {
        return T8_jumpFloor(target - 1) + T8_jumpFloor(target - 1);
        }
        return 0;
    }
    public static void main(String[]args){

        }
}

