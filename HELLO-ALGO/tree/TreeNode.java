import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val; // 节点值
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    // BFS
    public List<Integer> levelOrder() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
    }

    /* DFS */
    // 前序
    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public List preOrderRes() {
        List<Integer> list = new ArrayList<>();
        preOrder(this, list);
        return list;
    }
}