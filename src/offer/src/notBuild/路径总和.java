package notBuild;

import javax.swing.tree.TreeNode;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/16 23:19
 * @Problem:
 * @Version 1.0
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int tmpValue) {
        if (root == null) {
            return false;
        }

        // if (tmpValue == targetSum) {
        //     return true;
        // }
        // // 做选择
        // tmpValue += root.val;
        // // 当走到叶子节点时，这样写由于23行直接返回了false，并没有去看右叶子节点是否为null
        // dfs(root.left, targetSum, tmpValue);
        // dfs(root.right, targetSum, tmpValue);
        // return false;

        // 先做选择
        tmpValue += root.val;
        // 再进行判断
        if (root.left == null && root.right == null) {
            return tmpValue == targetSum;
        }
        return dfs(root.left, targetSum, tmpValue) || dfs(root.right, targetSum, tmpValue);
    }

    public static void main(String[] args) {
        路径总和 test = new 路径总和();
        TreeNode root = null;
        int targetSum = 22;
        test.hasPathSum(root, targetSum);
    }
}
