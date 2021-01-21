package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StackProblems {


    public static void main(String[] arg) {
        int[] a = {6, 2, 5, 4, 5, 1, 6};
//        System.out.println(nearest_greatest_toRight(a));
//        System.out.println(nearest_greatest_toLeft(a));

//        System.out.println(nearest_smallest_toLeft(a));
//        System.out.println(nearest_smallest_toRight(a));
//        int[] stock_span = nearest_greatest_toLeft(a);
//        System.out.println(Arrays.toString(stock_span));
    }

    //
//    static ArrayList<Integer> nearest_greatest_toRight(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = a.length - 1; i >= 0; i--) {
//            if (stack.isEmpty()) {
//                al.add(-1);
//            } else {
//                while (!stack.isEmpty() && a[i] >= stack.peek())
//                    stack.pop();
//                if (stack.isEmpty())
//                    al.add(-1);
//                else
//                    al.add(stack.peek());
//            }
//            stack.add(a[i]);
//        }
//        Collections.reverse(al);
//        return al;
    //  }
//    static ArrayList<Integer> nearest_smallest_toRight(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = a.length - 1; i >= 0; i--) {
//            if (stack.isEmpty()) {
//                al.add(-1);
//            } else {
//                while (!stack.isEmpty() && a[i] <= stack.peek())
//                    stack.pop();
//                if (stack.isEmpty())
//                    al.add(-1);
//                else
//                    al.add(stack.peek());
//            }
//            stack.add(a[i]);
//        }
//        Collections.reverse(al);
//        return al;
//    }

    //
//    static ArrayList<Integer> nearest_greatest_toLeft(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            if (stack.isEmpty()) {
//                al.add(-1);
//            } else {
//                while (!stack.isEmpty() && a[i] >= stack.peek())
//                    stack.pop();
//                if (stack.isEmpty())
//                    al.add(-1);
//                else
//                    al.add(stack.peek());
//            }
//            stack.add(a[i]);
//        }
//        return al;
//    }
//
//    static ArrayList<Integer> nearest_smallest_toLeft(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            if (stack.isEmpty()) {
//                al.add(-1);
//            } else {
//                while (!stack.isEmpty() && a[i] <= stack.peek())
//                    stack.pop();
//                if (stack.isEmpty())
//                    al.add(-1);
//                else
//                    al.add(stack.peek());
//            }
//            stack.add(a[i]);
//        }
//        return al;
//    }

//    static int[] nearest_greatest_toLeft(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//
//        int[] al = new int[a.length];
//        al[0] = 1;
//        stack.add(0);
//        for (int i = 1; i < a.length; i++) {
//
//            while (!stack.isEmpty() && a[i] >= a[stack.peek()])
//                stack.pop();
//
//            al[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
//            stack.add(i);
//        }
//        return al;
//    }

    //    Area under histogram
//    static int Area_under_histogram(int[] a) {
//        Stack<Integer> stack = new Stack<>();
//        int max = Integer.MIN_VALUE;
//        System.out.println(Arrays.toString(a));
//        ArrayList<Integer> l = nearest_smallest_toLeft(a);
//        ArrayList<Integer> r = nearest_smallest_toRight(a);
//        System.out.println(l);
//        System.out.println(r);
//        for (int i = 0; i < a.length; i++) {
//            max = Math.max((r.get(i) - l.get(i) - 2) * a[i], max);
//
//        }
//        return max;
//
//    }

}
