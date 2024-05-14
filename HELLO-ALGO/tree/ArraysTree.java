import java.util.ArrayList;
import java.util.List;

public class ArraysTree {
    private List<Integer> tree;

    // 构造方法
    public ArraysTree(List<Integer> list) {
        tree = new ArrayList<>(list);
    }

    // 列表容量
    public int size() {
        return tree.size();
    }

    // 获取索引为 i 节点的值
    public Integer val(int i) {
        if (i < 0 || i >= size()) {
            return null;
        }
        return tree.get(i);
    }

    // 获取索引为 i 节点的左子节点的索引
    public Integer left(int i) {
        return i * 2 + 1;
    }

    // 获取索引为 i 节点的右子节点的索引
    public Integer right(int i) {
        return i * 2 + 2;
    }

    // 层序遍历
    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        for (int i : tree) {
            res.add(i);
        }
        return res;
    }

    // 深度优先遍历
    public void dfs(Integer i, String order, List<Integer> res) {
        if (val(i) == null) {
            return;
        }
        if (order.equals("pre")) {
            res.add(val(i));
        }
        dfs(left(i), order, res);
        if (order.equals("in")) {
            res.add(val(i));
        }
        dfs(right(i), order, res);
        if (order.equals("post")) {
            res.add(val(i));
        }
    }

    // 前序遍历
    public List<Integer> preOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    // 中序遍历
    public List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    // 后序遍历
    public List<Integer> postOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }
}
