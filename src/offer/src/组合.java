import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/18 23:51
 * @Problem:
 * @Version 1.0
 */
public class 组合 {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        int [] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int[] visited = new int[n];
        backTrack(arr, k, visited, 0);
        return res;
    }

    public void backTrack(int[] arr, int k, int[] visited, int index) {
        if(path.size() == k) {
            res.add(new LinkedList<Integer>(path));
            return;
        }
        for(int i = index; i < arr.length; i++) {
            if(path.contains(arr[i]) || visited[i] == 1) continue;

            visited[i] = 1;
            if(i > index && i < k && path.size() > 1 && path.get(path.size() - 2) > path.get(path.size() - 1)) {
                continue;
            }
            path.add(arr[i]);
            backTrack(arr, k, visited, index++);
            visited[i] = 0;
            path.remove(path.size() -  1);
        }
    }

    public static void main(String[] args) {
        组合 test = new 组合();
        int n = 4;
        int k = 3;
        List<List<Integer>> res = test.combine(n, k);
        System.out.println(res);
    }
}
