package linkedlist;

public class CircularList<T>{
    Node<T> tail;
    private int size=0;
    static class Node<T>{
        T data;
        Node<T> next;
        Node(T d)
        {
            data = d;
        }
    }
    int size(){
        return size;
    }
    void addFirstNode(T d)
    {
        tail = new Node<T>(d);
        tail.next = tail;
    }
    void append(T d){
        if(tail==null) {
            addFirstNode(d);
        }
        else{
            Node<T> new_node = new Node<>(d);
            new_node.next = tail.next;
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }
    void push(T d){
        if(tail==null) {
            addFirstNode(d);
        }
        else{
            Node<T> new_node = new Node<>(d);
            new_node.next = tail.next;
            tail.next = new_node;
        }
        size++;
    }
    @Override
    public String toString(){
        if(tail==null)
            return "[]";
        StringBuilder result = new StringBuilder("[");
        Node<T> start = tail.next;
        do {
            result.append(start.data).append(",");
            start = start.next;
        }while (start!=tail.next);
        result.replace(result.length()-1,result.length(),"]");
        return result.toString();

    }
    public static void main(String[] arg){
        CircularList<Integer> list = new CircularList<>();
        list.append(1);
        list.push(4);

        System.out.println(list);
    }
}