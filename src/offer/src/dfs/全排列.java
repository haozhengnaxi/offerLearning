package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/2 23:16
 * @Problem: 46. 全排列  https://leetcode-cn.com/problems/permutations/
 * @Version 1.0
 */
public class 全排列 {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        // 用链表便于增删首尾元素
        LinkedList<Integer> res = new LinkedList<Integer>();
        dfs(nums, res);
        return list;

    }
    public void dfs(int[] nums, LinkedList<Integer> res) {
        if (res.size() == nums.length) {
            list.add(new LinkedList<Integer>(res));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(res.contains(nums[i])) {
                continue;
            }
            // 做选择
            res.add(nums[i]);
            // 选择下一个数
            dfs(nums, res);
            //  取消选择(回到上一个节点)
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        全排列 test = new 全排列();
        int[] array = {1 ,2, 3};
        System.out.println(test.permute(array));
    }
}
