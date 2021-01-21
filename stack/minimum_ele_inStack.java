package stack;

import java.util.Stack;

public class minimum_ele_inStack {
    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> ss = new Stack<>();

    public static void main(String[] arg) {
        push(10);
        push(2);

        push(20);
        push(5);


        System.out.println(s + "\n" + ss);
        System.out.println(getMin());
    }

    public static void push(int a) {
        s.add(a);

        if (ss.isEmpty() || a <= ss.peek())
            ss.add(a);
    }

    public static int pop() {
        if (s.isEmpty()) return -1;
        int temp = s.peek();
        s.pop();
        if (temp == ss.peek())
            ss.pop();
        return temp;
    }

    public static int getMin() {
        if (!s.isEmpty())
            return ss.peek();
        else
            return -1;
    }
}