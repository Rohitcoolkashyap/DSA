package tree;

public class BinarySearchTree {
    static Node root;

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static void insert(int key) {
        root = insertUtil(root, key);
    }

    public static Node insertUtil(Node root, int key) {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertUtil(root.left, key);
        else if (key > root.key)
            root.right = insertUtil(root.right, key);
        /* return the (unchanged) node pointer */

        return root;
    }

    // inorder traversal
    public static void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    // search key
    public static Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        // key is in right subtree
        if (root.key < key)
            return search(root.right, key);
        // key is in left subtree
        return search(root.left, key);
    }

    public static void main(String[] arg) {
        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(70);
        insert(60);
        insert(80);
        inorder(root);
        System.out.println();
        System.out.println(search(root, 60));
    }

}