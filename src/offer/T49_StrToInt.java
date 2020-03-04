package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/4 23:00
 * @Version 1.0
 */
public class T49_StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        // 首先判断首位是否为正负号,且在0到9之间
        char c = str.charAt(0);
        int flag;
        if (c == '+') {
            flag = 1;
        }
        else if (c == '-') {
            flag = -1;
        }
        else if (c >= '0' && c <= '9') {
            flag = 1;
        }
        else
            return 0;
        int len = str.length();
        // int型最大数值为10位数
        if (len > 10) {
            return 0;
        }
        long value = 0;
        for (int i = 1; i < len; i++) {
            char num = str.charAt(i);
            if (i < len && num >= '0' && num <= '9') {
                value = value * 10 + (num - 48);
            }
            else
                return 0;
        }
        if (flag == 1 && value <= Integer.MAX_VALUE) {
            return (int) (flag * value);
        }
        else if (flag == -1 && value >= Integer.MIN_VALUE) {
            return (int) (flag * value);
        }
        else
            return 0;
    }
    public static void main(String[] args) {
        T49_StrToInt test = new T49_StrToInt();
        String a = "++2147483647";
        int out = test.StrToInt(a);
        System.out.println(out);
    }
}
