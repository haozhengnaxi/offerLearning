package dfs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/17 22:59
 * @Problem: 全排列 II  https://leetcode-cn.com/problems/permutations-ii/
 * @Version 1.0
 */
public class 全排列II {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    Deque path = new LinkedList<Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        // 排序，对后续的剪枝很重要
        // 所谓剪枝，就是舍弃一些没必要遍历的量，提升效率
        Arrays.sort(nums);
        dfs(nums, visited);
        return list;
    }

    public void dfs(int[] nums, int[] visited) {
        if(path.size() == nums.length) {
            list.add(new LinkedList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            // 已经使用的不再添加到path中
            if(visited[i] == 1) continue;
            // 之前已经对path排序
            // 已经
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 1) {
                continue;
            }
            visited[i] = 1;
            path.add(nums[i]);
            dfs(nums, visited);
            path.pollLast();
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列II test = new 全排列II();
        List<List<Integer>> list = test.permuteUnique(nums);
        System.out.println(list);
    }
}
