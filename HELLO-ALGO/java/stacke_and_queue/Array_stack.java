import java.util.ArrayList;
import java.util.Arrays;

class InnerArray_stack {
    ArrayList<Integer> array_stack = new ArrayList<>();
    
    // 获取栈的长度
    public int size() {
        return array_stack.size();
    }

    // 是否为空
    public boolean isEmpty() {
        return array_stack.size() == 0;
    }

    // 获取栈顶元素
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return array_stack.get(array_stack.size() - 1);
    }

    // 入栈
    public void push(int val) {
        array_stack.add(val);
    }

    // 出栈
    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return array_stack.remove(array_stack.size() - 1);
    }
    
    public Object[] toArray() {
        return array_stack.toArray();
    }
}

public class Array_stack {
    public static void main(String[] args) {
        InnerArray_stack stack = new InnerArray_stack();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(Arrays.toString(stack.toArray()));
    }

    
}
