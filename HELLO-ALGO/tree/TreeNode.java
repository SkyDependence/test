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

    // 中序
    private List<Integer> inList = new ArrayList<>();

    private void inOrder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public List<Integer> inOrderRes() {
        inList.clear();
        inOrder(this, inList);
        return inList;
    }

    // 后序
    private List<Integer> postList = new ArrayList<>();

    private void postOrder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postOrderRes() {
        postList.clear();
        postOrder(this, postList);
        return postList;
    }

}