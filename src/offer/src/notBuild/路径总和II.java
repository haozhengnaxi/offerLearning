/**
 * @Author T.Y.Shang
 * @Date: 2021/3/17 22:55
 * @Problem:
 * @Version 1.0
 */
public class 路径总和II {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque path = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }

    public void dfs(TreeNode root, int targetSum, int tmpValue) {
        if(root == null) {
            return;
        }
        tmpValue += root.val;
        path.offerLast(root.val);
        if(root.left == null && root.right == null && tmpValue == targetSum) {
            res.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum, tmpValue);
        dfs(root.right, targetSum, tmpValue);
        path.pollLast();
    }
}
