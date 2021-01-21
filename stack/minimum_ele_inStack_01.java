package stack;

import java.util.Stack;

public class minimum_ele_inStack_01 {
    static int min_element = -1;
    static Stack<Integer> s = new Stack<>();
    minimum_ele_inStack_01(){
        min_element=-1;
        s = new Stack<>();
    }
    public static void main(String[] arg) {

    }
    public static void push(int a) {
        if (s.empty()) {
            s.add(a);
            min_element = a;
        } else {
            if (a >= min_element)
                s.add(a);
            else {
                s.add((2 * a) - min_element);
                min_element = a;
            }
        }
    }

    public static void pop() {
        int t=-1;
        if (s.isEmpty()) return;
        if (s.peek() >= min_element)
            s.pop();


        else {
            t = s.peek();
            s.pop();
            min_element = 2 * min_element - t;
        }
        if (s.isEmpty()) min_element =-1;


    }

    public static int top() {
        if (s.isEmpty()) return -1;

        return s.peek() >= min_element ? s.peek():min_element;
    }

    public static int getMin() {
        // if(s.isEmpty()) return -1;
        return min_element;

    }
}
