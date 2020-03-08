package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/8 23:29
 * @Version 1.0
 */
public class T12_numberExponent(double base, int exponent) {
    if (exponent == 0) return 1;
    if (exponent == 1) return base;
    if (base == 0.0) return 0;
    // 先判断幂指数的正负
    boolean isPositive = true;
    if (exponent < 0) {
        exponent = -exponent;
        isPositive = false;
        }
    double pow = T12_numberExponent(base * base , exponent / 2);
    if (exponent % 2 != 0) {
        pow = pow * base;
        }
    if(!isPositive) {
        pow = 1 / pow;
        }
    return pow;
}
