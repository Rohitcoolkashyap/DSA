package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root = null;
    private int node_count = 0;

    private static class Node {
        int data;
        Node left, right;

        Node(Node left, Node right, int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    int size() {
        return node_count;
    }
    boolean isEmpty() {
        return size() == 0;
    }
    boolean contains(int data) {
        return contains(root, data);
    }
    boolean contains(Node node, int data) {
        if (node == null)
            return false;
        if (data < node.data)
            return contains(node.left, data);
        else if(data > node.data)
            return contains(node.right, data);
        else
            return true;
    }
    void add(int data) {
        if (contains(data))
            return;
        root = add(root, data);
        node_count++;
    }
    Node add(Node node, int data) {
        if (node == null){
            node = new Node(null, null, data);
        }
        else {
            if (data < node.data) {
                node.left = add(node.left, data);
            }
            else if(data > node.data)
                node.right = add(node.right, data);
        }
        return node;
    }
    void preorder(Node node){
        if(node==null)
            return;
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
    }
    void postorder(Node node){
        if(node==null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");

    }
    void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);
    }
    /* Given a binary tree. Print its nodes in level order
    using array for implementing queue  */
    void levelOrder()
    {
        if(root==null)
            throw new NullPointerException();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    boolean remove(int data){
        if(contains(data))

        {
            root = remove(root,data);
            node_count--;
            return true;
        }
        return false;
    }
    Node remove(Node node,int data){
        if(data<node.data)
            node.left = remove(node.left,data);
        else if(data>node.data)
            node.right = remove(node.right,data);
        else{
            if(node.left == null)
            {
                System.out.println(node.data);
                Node right_child = node.right;
               // node.data = null;
                node = null;
                return right_child;
            }
            else if(node.right == null)
            {
                Node left_child = node.left;
               // node.data = null;
                node = null;
                return left_child;
            }
            else if(node.right!=null)
            {
                Node tmp = min_value(node.right);
                node.data = tmp.data;

                node.right = remove(node.right,tmp.data);
            }
        }
        return node;
    }
    Node min_value(Node node){
        while (node.left != null)
             node = node.left;
        return node;
    }
    public static void main(String[] arg){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.inorder(tree.root);

    }
}