package linkedlist;

public class doublyCircularList<T> {
    Node<T> head,tail;
    private int size=0;
    static class Node<T>{
        T data;
        Node<T> next,prev;
        Node(T _data){
            data = _data;

        }
    }
    void addFirstNode(T data){
        Node<T> new_node = new Node<>(data);
        head = tail = new_node;
        head.next = new_node;
        head.prev = new_node;
    }
    void append(T data){
        if(head==null)
            addFirstNode(data);
        else{
            Node<T> new_node = new Node<>(data);
            new_node.prev = tail;
            new_node.next = head;
            tail.next = new_node;
            head.prev = new_node;
            tail = new_node;
        }
        size++;
    }
    void push(T data){
        if(head==null)
            addFirstNode(data);
        else {
            Node<T> new_node = new Node<>(data);
            new_node.next = head;
            new_node.prev = tail;
            tail.next = new_node;
            head.prev = new_node;
            head = new_node;
        }
        size++;
    }
    void removeFirst(){
        if(head==null) throw new NullPointerException("Linked list is empty");
        if(size==1)
            head = tail = null;
        else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }
    void removeLast(){
        if(head==null) throw new NullPointerException("Linked list is empty");
        if(size==1)
            head = tail = null;
        else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }
    @Override
    public String toString(){
        if(head==null)
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
        doublyCircularList<Integer> list = new doublyCircularList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.push(20);

        list.append(4);
        list.append(5);
        list.append(6);
        list.push(10);
        System.out.println(list);
    }
}
