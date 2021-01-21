package linkedlist;

// A simple Java program to introduce a linked list
class LinkedList {
    int index = 0;
    private int size = 0;
    Node head; // head of list and Node class reference variable
    /* Linked list Node. This inner class is made static so that
    main() can access it and no need to create instance of upper class to  instantiated Node class*/
    static class Node {
        int data; // for storing data
        Node next; // storing reference of next node or object
        Node(int d)
        {
            data = d;
            next = null;
        } // Constructor
    }
    public int size(){
        return size;
    }
    public void push(int data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        size++;
    }
    public void append(int data){
        Node new_node = new Node(data);
        if(head == null)
            head = new_node;
        else {
            Node n = head;
            while (n.next != null) 
                n = n.next;
            n.next = new_node;
        }
        size++;
    }
    public void insert(int i,int data){
        Node n = head;
        Node new_node = new Node(data);

        while (n!=null){
            if(i==0)
            {
                new_node.next = n;
                head = new_node;
                break;
            }
            if(i>size+1) throw new IndexOutOfBoundsException();
            else if(i-1==index)
            {
                Node c = n.next;
                n.next = new_node;
                new_node.next = c;
            }
            n = n.next;
            index++;
        }
        size++;
    }
    void middleElement(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        System.out.println(slow.data);
    }
    void deleteAll(){
        head = null;
    }
    void remove(int ele) throws Exception {
        Node n = head;
        if(size ==0) throw new Exception("element: "+ele+" size: "+size);

        if(ele == head.data)
        {
            head = n.next;
            size--;
        }
        else {
            while (n.next!=null) {
                if (ele == n.next.data) {
                    n.next = n.next.next;
                    size--;
                    break;
                }
                n = n.next;
            }
        }
    }
    @Override
    public String toString(){
        if(head==null)
            return "[]";
        else {
            Node n = head;
            StringBuilder s = new StringBuilder("[");

            while (n != null) {
                s.append(n.data).append(",");
                n = n.next;
            }
            s.replace(s.length() - 1, s.length(), "]");
            return s.toString();
        }
    }
    /* method to create a simple linked list with 3 nodes*/
    public static void main(String[] args) throws Exception {
        /* Start with the empty list. */
        LinkedList llist = new LinkedList();
        LinkedList llist2 = new LinkedList();
        llist2.append(1);


        llist.append(1);
        llist.append(2);
        llist.append(3);
        llist.append(4);
        llist.append(5);
        llist.append(6);
        System.out.println(llist2.head.data);
    }
}