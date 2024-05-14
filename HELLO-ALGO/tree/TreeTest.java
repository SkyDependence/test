import java.util.*;

public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;

        // BFS
        // System.out.println(root.levelOrder());
        // System.out.println("/******************************/");
        // System.out.println(root.preOrderRes());
        // System.out.println("/******************************/");
        // System.out.println(root.inOrderRes());
        // System.out.println("/******************************/");
        // System.out.println(root.postOrderRes());

        // 创建一个示例数组树
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ArraysTree tree = new ArraysTree(list);

        // 测试层序遍历
        List<Integer> levelOrderResult = tree.levelOrder();
        System.out.println("层序遍历结果: " + levelOrderResult);

        // 测试前序遍历
        List<Integer> preOrderResult = tree.preOrder();
        System.out.println("前序遍历结果: " + preOrderResult);

        // 测试中序遍历
        List<Integer> inOrderResult = tree.inOrder();
        System.out.println("中序遍历结果: " + inOrderResult);

        // 测试后序遍历
        List<Integer> postOrderResult = tree.postOrder();
        System.out.println("后序遍历结果: " + postOrderResult);
    }
}
