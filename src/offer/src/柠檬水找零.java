/**
 * @Author T.Y.Shang
 * @Date: 2021/4/14 23:32
 * @Problem:
 * @Version 1.0
 */
public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        if(bills == null) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                fiveCount++;
                continue;
            } else if (bills[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                    continue;
                }
                else {
                    return false;
                }
            } else {
                if (tenCount > 0) {
                    if (fiveCount > 0) {
                        tenCount--;
                        fiveCount--;
                        continue;
                    } else return false;
                } else if (fiveCount > 2) {
                    fiveCount = fiveCount - 3;
                    continue;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        柠檬水找零 test = new 柠檬水找零();
        int[] bills = {5,5,10,10,20};
        boolean result = test.lemonadeChange(bills);
        System.out.println(result);
    }
}
