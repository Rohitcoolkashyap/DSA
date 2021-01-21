package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Maximum_Area_UnderHistogram {

    public static void main(String[] arg) {
        int[] a = {2, 4};

        System.out.println("maximum area under histogrm = " + Area_under_histogram(a));
    }

    static ArrayList<Integer> nearest_smallest_toRight(int[] a) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                al.add(a.length);
            } else {
                while (!stack.isEmpty() && a[i] <= a[stack.peek()])
                    stack.pop();
                if (stack.isEmpty())
                    al.add(a.length);
                else
                    al.add(stack.peek());
            }
            stack.add(i);
        }
        Collections.reverse(al);
        return al;
    }

    static ArrayList<Integer> nearest_smallest_toLeft(int[] a) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                al.add(-1);
            } else {
                while (!stack.isEmpty() && a[i] <= a[stack.peek()])
                    stack.pop();
                if (stack.isEmpty())
                    al.add(-1);
                else
                    al.add(stack.peek());
            }
            stack.add(i);
        }
        return al;
    }

    static int Area_under_histogram(int[] a) {
        int max = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> l = nearest_smallest_toLeft(a);
        ArrayList<Integer> r = nearest_smallest_toRight(a);
//        System.out.println(l);
//        System.out.println(r);
        for (int i = 0; i < a.length; i++) {
            max = Math.max((r.get(i) - l.get(i) - 1) * a[i], max);

        }
        return max;

    }
}
