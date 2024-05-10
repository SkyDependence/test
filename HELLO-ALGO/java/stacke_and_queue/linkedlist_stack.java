import java.util.Arrays;

class LinkedListStack {
    private ListNode stackPeek; // 将头结点作为栈顶
    private int stkSize = 0; // 栈的长度

    public LinkedListStack() {
        stackPeek = null;
    }

    public int size() {
        return stkSize;
    }

    public boolean isEmpty() {
        return stkSize == 0;
    }

    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stkSize++;
    }

    public int pop() {
        int num = stackPeek.val;
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stackPeek.val;
    }

    public int[] toArray() {
        ListNode index = stackPeek;
        int[] res = new int[stkSize];
        for (int i = stkSize - 1; i >= 0; i--) {
            res[i] = index.val;
            index = index.next;
        }
        return res;
    }
}

class ListNode {
    int val; // 节点值
    ListNode next; // 后继节点引用
    ListNode prev; // 前驱节点引用

    ListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}

public class linkedlist_stack{
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        System.out.println(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        System.out.println(Arrays.toString(stack.toArray()));


    }
}
