import java.util.Collections;

/**
 * @Author T.Y.Shang
 * @Date: 2021/3/23 22:55
 * @Problem: 107. 二叉树的层序遍历 II https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @Version 1.0
 */
public class 二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        if(root == null) {
            return tmp;
        }

        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            tmp.add(list);
        }
//        Collections.reverse(res);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<List<Integer>> deque = new LinkedList<List<Integer>>();
        for(int j = 0; j < tmp.size(); j++) {
            deque.offer(tmp.get(j));
        }
        for(int k = 0; k < tmp.size(); k++) {
            res.add(deque.pollLast());
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
