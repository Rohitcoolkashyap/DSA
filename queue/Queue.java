package queue;

import java.util.LinkedList;

public class Queue<T> {

    private final LinkedList<T> list = new LinkedList<>();

    // Return the size of the queue
    public int size() {
        return list.size();
    }

    // Returns whether or not the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Peek the element at the front of the queue
    // The method throws an error is the queue is empty
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    // Poll an element from the front of the queue
    // The method throws an error is the queue is empty
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    // Add an element to the back of the queue
    public void push(T elem) {
        list.addLast(elem);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] arg) {
        Queue<Integer> q = new Queue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q);
    }
}