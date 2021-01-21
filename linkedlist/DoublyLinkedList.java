package linkedlist;

import java.util.EmptyStackException;

public class DoublyLinkedList<T> {
   private int size = 0;
    Node<T> head; //references
    Node<T> tail;
    static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next; //to store prev & next reference of object
        Node(T d)
        {
            data = d;
        }
        //1<->2<->3<->4
    }
    public int size(){
        return size;
    } //O(1)
    public boolean isEmpty(){
        return size==0;
    } //O(1)
    public void append(T data){ //O(1)
        Node<T> new_node = new Node<>(data);
        if(size==0) {
            head = tail = new_node;
            new_node.prev = null;
            new_node.next = null;
            size++;
            return;
        }
        tail.next = new_node;
        new_node.prev = tail;
        tail = new_node;
        tail.next = null;
        size++;
    }
    public void push(T data){ // 0(1)
        Node<T> new_node = new Node<>(data);
        new_node.prev = null;
        if(size==0)
        {
            head = tail = new_node;
        }
        else {
            new_node.next = head; //add head in next of new_node so new_node come before head
            head.prev = new_node;  //add new_node is prev node of head
            head = new_node; // make new_node head
        }
        size++;
    }
    public void insert(int _index,T data){
        Node<T> new_node = new Node<>(data);
        Node<T> n = head;
        int index = 0;
        if(_index==0)
        {
            head.prev = new_node;
            new_node.next = head;
            head = new_node;
            size++;
            return;
        }
        if(_index >= size) throw new IndexOutOfBoundsException();

        while (n != null){
            if(index == _index-1)
            {
                Node<T> c = n.next;

                n.next = new_node;
                new_node.prev = n;

                new_node.next = c;
                c.prev = new_node;
                size++;
            }
            index++;

            n = n.next;
        }

    }
    public T peekFirst(){
        return head.data;
    } //0(1)
    public T peekLast(){return tail.data; } //0(1)

    public void removeFirst(){  //0(n)
        if(size==0) throw new EmptyStackException();
            if(size==1)
            {
                head = null;
                tail = null;
                size--;
            }
            else {
                head = head.next;
                size--;
                head.prev = null;
            }
    }
    public void removeLast(){
        if(size==0) throw new EmptyStackException();
        if(size==1)
        {
            head =null;
            tail = null;
            size--;
        }
        else {
            tail = tail.prev;
            size--;
            tail.next = null;
        }
    }

    public String toString(){ //0(n)
        if(head==null)
            return "[]";
        StringBuilder s = new StringBuilder("[");
        Node<T> n = head;
        while (n!=null)
        {
            s.append(n.data).append(",");
            n = n.next;
        }
        s.replace(s.length()-1,s.length(),"]");
        return s.toString();

    }

    public static void main(String[] arg){
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("rohit");
        list.append("ram");
        list.append("rijul");
        list.append("rajat");
        list.insert(3,"lakh");
        System.out.println(list);


        System.out.println(list);



        }
    }

