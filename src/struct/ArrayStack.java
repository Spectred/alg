package struct;


/**
 * 基于数组实现的顺序栈
 */
public class ArrayStack {
    /**
     * 数组
     */
    private Object[] items;
    /**
     * 栈中元素的个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int n;

    public ArrayStack(int n) {
        this.n = n;
        this.items = new Object[n];
        this.count = 0;
    }

    /**
     * 入栈
     *
     * @param item
     * @return
     */
    public boolean push(Object item) {
        // 栈满了
        if (count == n) return false;
        // 将item放到下标为count的位置，并且count+1
        items[count++] = item;
        return true;
    }

    public Object pop() {
        // 栈是空的
        if (count == 0) return null;
        // 下表是count-1的数组元素，并且count-1
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        arrayStack.push("6");

        for (int i = 0; i < 7; i++) {
            System.out.println((String) arrayStack.pop());
        }
    }
}
