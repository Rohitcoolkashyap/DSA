package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Max_Area_Rectangle_in_binary_matrix {
    public static void main(String[] arg) {
        int[][] arr = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        int[] a = new int[arr[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1)

                    a[j] += arr[i][j];
                else
                    a[j] = 0;

            }
            max = Math.max(Area_under_histogram(a),max);

        }
        System.out.println(max);

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
        ArrayList<Integer> l = nearest_smallest_toLeft(a);
        ArrayList<Integer> r = nearest_smallest_toRight(a);
;
        for (int i = 0; i < a.length; i++) {
            max = Math.max((r.get(i) - l.get(i) - 1) * a[i], max);

        }
        return max;

    }


}
