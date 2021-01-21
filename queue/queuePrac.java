package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class queuePrac {
    public static void main(String[] arg) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        int k=3;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.add(q.peek());
            q.poll();

        }
       // System.out.println(stack);
        while (!stack.isEmpty()){
            q.offer(stack.peek());
            stack.pop();
        }


        for (int i = 0; i < q.size()-k; i++) {
            q.offer(q.peek());
            q.poll();

        }
        System.out.println(q);


    }
}
