/**
 * @Author T.Y.Shang
 * @Date: 2021/3/26 22:52
 * @Problem: 101. 对称二叉树  https://leetcode-cn.com/problems/symmetric-tree/
 * @Version 1.0
 */
public class 对称二叉树 {
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        return compare(root.left, root.right);
//    }
//
//    public boolean compare(TreeNode left, TreeNode right) {
//        if (left == null && right != null) return false;
//        else if(left != null && right == null) return false;
//        else if(left == null && right == null) return true;
//        else if(left.val != right.val) return false;
//
//        // 处理单层递归的逻辑，即左右节点都不为空切左右节点都相等的情况，递归调用下钻
//        boolean inside = compare(left.right, right.left);
//        boolean outside = compare(right.right, left.left);
//        return outside && inside;
//    }

    // 使用迭代的方式，也即栈
    if(root == null) {
        return true;
    }
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
        TreeNode right = queue.poll();
        TreeNode left = queue.poll();
        if(right == null && left == null) {
            continue;
        }
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left != null && right != null && left.val != right.val) return false;
        queue.offer(left.left);
        queue.offer(right.right);
        queue.offer(left.right);
        queue.offer(right.left);
    }
        return true;
}
