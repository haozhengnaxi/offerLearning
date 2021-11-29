package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @Author T.Y.Shang
 * @Date: 2021/11/17 22:05
 * @Problem:
 * @Version 1.0
 */
public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int num1 : nums1) {
            for(int num2 : nums2) {
                treeMap.put(num1 + num2, treeMap.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        int res = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if(treeMap.containsKey(0 - num3 - num4)) {
                    res += treeMap.get(0 - num3 - num4);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        四数相加II test = new 四数相加II();
        System.out.println(test.fourSumCount(new int[] {1,2}, new int[] {-2,-1}, new int[] {-1,2}, new int[] {0,2}));
    }
}
