package 设计题.排序总结;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/9/5 23:41
 * @Problem:
 * @Version 1.0
 */
public class 列表排序 {
    public void sortListAsc(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * 生成bit个数的随机数
     * @param bit 数量
     * @return 结果
     */
    public List<Integer> getRandom(int num) {
        List<Integer> list = new ArrayList<>();
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            for(int i = 0; i < num; i++) {
                list.add(sr.nextInt(20));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        列表排序 test = new 列表排序();
        List<Integer> list = test.getRandom(5);
        test.sortListAsc(list);
    }
}
