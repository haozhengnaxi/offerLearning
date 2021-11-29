
import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/23 21:37
 * @Problem: 102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Version 1.0
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // 定义一个队列保存树节点，不丢失节点值，左子树，右子树信息
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 每层有几个节点，队列出队就出几次
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
