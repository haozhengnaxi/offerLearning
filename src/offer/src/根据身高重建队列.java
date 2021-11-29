
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/5/10 22:12
 * @Problem: 406. 根据身高重建队列  https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @Version 1.0
 */
public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) {
            return people;
        }
        int len = people.length;
        // 先按照身高大小，从高到低排序
        int [][] res = new int[len][len];
        List<ArrayList<int [][]>> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (people[i][0] > people[i + 1][0]) {
//                list.add(i, people[i][0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        根据身高重建队列 test = new 根据身高重建队列();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = test.reconstructQueue(people);
        System.out.println(res);
    }
}
