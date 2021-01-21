package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class DynamicStack<T> {
    LinkedList<T> stack = new LinkedList<>();
    // append
    void append(T data){
        stack.addLast(data);
    }
    public int size() {
        return stack.size();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }
    // Pop an element off the stack
    // Throws an error is the stack is empty
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.removeLast();
    }

    // Peek the top of the stack without removing an element
    // Throws an exception if the stack is empty
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.peekLast();
    }
    public static void main(String[] arg){
        DynamicStack<Integer> n = new DynamicStack<>();
        n.append(1);
        n.append(2);
        System.out.println(n.peek());

    }


}
