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

    // Remove a value from this binary tree if it exists, O(n)
    public static boolean remove(int key) {
        if (search(root, key).key == key) {
            root = remove(root, key);
            return true;
        }
        return false;
    }

    private static Node remove(Node node, int key) {
        if (node == null) return null;

        // Dig into left subtree, the value we're looking
        // for is smaller than the current value
        if (key < node.key) {
            node.left = remove(node.left, key);
        }
        // Dig into right subtree, the value we're looking
        // for is greater than the current value
        else if (key > node.key) {
            node.right = remove(node.right, key);
        }
        // Found the node we wish to remove
        else {
            // This is the case with only a right subtree or
            // no subtree at all. In this situation just
            // swap the node we wish to remove with its right child.
            if (node.left == null) {
                Node rightChild = node.right;
                node = null;
                return rightChild;
            }
            // This is the case with only a left subtree or
            // no subtree at all. In this situation just
            // swap the node we wish to remove with its left child.
            else if (node.right == null) {
                Node leftChild = node.left;
                node = null;
                return leftChild;
            } else {

                // When removing a node from a binary tree with two links the
                // successor of the node being removed can either be the largest
                // value in the left subtree or the smallest value in the right
                // subtree. In this implementation I have decided to find the
                // smallest value in the right subtree which can be found by
                // traversing as far left as possible in the right subtree.

                // Find the leftmost node in the right subtree
                Node tmp = findMin(node.right);

                // Swap the data
                node.key = tmp.key;

                // Go into the right subtree and remove the leftmost node we
                // found and swapped data with. This prevents us from having
                // two nodes in our tree with the same value.
                node.right = remove(node.right, tmp.key);
            }
        }
        return node;
    }

    private static Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // check is BST
    static public boolean isBst(Node node, int min, int max) {
        if (node == null) return true;
        return node.key >= min && node.key <= max && isBst(node.left, min, node.key) && isBst(node.right, node.key, max);
    }

    // convert bst to sorted linkedlist
    static class LinkedList {
        private Node head;
        private Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }
    }

    public static LinkedList flatten(Node root) {
        LinkedList l = new LinkedList();
        if (root == null) {
            l.head = l.tail = null;
            return l;
        }

        // Leaf Node
        if (root.left == null && root.right == null) {
            l.head = l.tail = root;
            return l;
        }
        // Left in not null
        if (root.left != null && root.right == null) {
            LinkedList leftLL = flatten(root.left);
            leftLL.tail.right = root;

            l.head = leftLL.head;
            l.tail = root;
            return l;
        }
        // right is not null
        if (root.left == null && root.right != null) {
            LinkedList rightLL = flatten(root.right);

            root.right = rightLL.head;

            l.head = root;
            l.tail = rightLL.tail;
            return l;

        }
        // both Sides are not null
        LinkedList leftLL = flatten(root.left);
        LinkedList rightLL = flatten(root.right);

        leftLL.tail.right = root;
        root.right = rightLL.head;

        l.head = leftLL.head;
        l.tail = rightLL.tail;
        return l;
    }
static void s(int[] b){
        b[0] = 100;
    System.out.println(b[0]);
}


/*    Binary Search Tree : Lowest Common Ancestor
    public static Node lca(Node root, int v1, int v2) {

        if(root == null)
            return null;
        if(root.data < v1 && root.data < v2)
            return lca(root.right,v1,v2);
        else if(root.data > v1 && root.data > v2)
            return lca(root.left,v1,v2);
        else
            return root;
    }*/
    public static void main(String[] arg) {
        int[] b = new int[2];
        s(b);
        System.out.println(b[0]);
        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(45);

        inorder(root);
//
//        remove(30);
//        System.out.println();
//        inorder(root);
//
//        System.out.println("\ncheck bst : " + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println();

        LinkedList l = flatten(root);
        Node t = l.head;
        while (t != null) {
            System.out.print(t.key + " ");
            t = t.right;
        }


    }

}