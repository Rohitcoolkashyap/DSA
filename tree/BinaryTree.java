package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTree {
    static Node root;

    /* A binary tree node has key, pointer to
    left child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;

        // constructor
        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    // inorder traversal
    public static void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    // inorder iterative
    public static void inorder_iterative(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        // traverse the tree
        while (curr != null || stack.size() > 0) {

         /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = stack.pop();

            System.out.print(curr.key + " ");

             /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }

    // preorder traversal
    static void preorder(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.key + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    // preorder iterative
    static void preorder_iterative(Node root) {
        if (root == null)
            return;

        // Start from root node (set curr
        // node to root node)
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        // traverse the tree
        while (curr != null || !stack.isEmpty()) {

            // Print left children while exist
            // and keep pushing right into the
            // stack.
            while (curr != null) {
                System.out.print(curr.key + " ");
                if (curr.right != null)
                    stack.add(curr.right);
                curr = curr.left;
            }

            // We reach when curr is NULL, so We
            // take out a right child from stack
            if (!stack.isEmpty())
                curr = stack.pop();
        }

    }

    // postorder traversal
    static void postorder(Node temp) {
        if (temp == null)
            return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.key + " ");
    }

    // postorder iterative
    static void postorder_iterative(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (true) {
            while (curr != null) {
                stack.add(curr);
                stack.add(curr);

                curr = curr.left;
            }

            if (stack.isEmpty())
                return;
            curr = stack.pop();

            if (!stack.isEmpty() && curr == stack.peek())
                curr = curr.right;
            else {
                System.out.print(curr.key + " ");
                curr = null;
            }

        }
    }


    static int heightOfTree(Node temp) {
        if (temp == null)
            return 0;
        int ls = heightOfTree(temp.left);
        int rs = heightOfTree(temp.right);
        return Math.max(ls, rs) + 1;
    }

    //level order recursive

    static void levelOrder(Node temp) {
        int height = heightOfTree(root);
        for (int i = 1; i <= height; i++) {
            levelOrderPrint(temp, i);
            System.out.println();
        }
    }

    static void levelOrderPrint(Node temp, int level) {
        if (temp == null) return;
        if (level == 1) {
            System.out.print(temp.key + " ");
            return;
        }
        levelOrderPrint(temp.left, level - 1);
        levelOrderPrint(temp.right, level - 1);
    }

    // level order iterative BSF
    static void levelOrderIterative(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            System.out.print(temp.key + " ");
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);

        }

    }

    // insert Nodes
    static void insert(Node temp, int key) {
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                queue.offer(temp.left);
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                queue.offer(temp.right);
        }
    }

    /* Function to delete given element
     in binary tree */

    static void deleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp;

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.offer(temp.right);
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else
                    q.offer(temp.left);
            }
        }

    }

    static void delete(Node root, int key) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.key == key)
                return;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node temp = null, keyNode = null;

        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key)
                keyNode = temp;

            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }
        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        }
    }

    /* binary tree questions*/
    static int countNodes(Node temp) {
        if (temp == null)
            return 0;
        return 1 + countNodes(temp.left) + countNodes(temp.right);
        // root + leftSubtree + rightSubtree

    }

    public static int getSize(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;

        return 1 + getSize(root.left) + getSize(root.right);
    }

    static int sumOfNodes(Node temp) {
        if (temp == null)
            return 0;
        return temp.key + sumOfNodes(temp.left) + sumOfNodes(temp.right);
    }

    // diameter of tree
    static int diameter(Node temp) {

        if (temp == null)
            return 0;

        int h1 = heightOfTree(temp.left);
        int h2 = heightOfTree(temp.right);

        int out1 = h1 + h2;
        int out2 = diameter(temp.left);
        int out3 = diameter(temp.right);

        return Math.max(out1, Math.max(out2, out3));

    }

    // sum replacement problem
    static int sumReplacement(Node temp) {
        if (temp == null)
            return 0;
        if (temp.left == null && temp.right == null)
            return temp.key;

        // recursive part postOrder
        int leftSum = sumReplacement(temp.left);
        int rightSum = sumReplacement(temp.right);
        int c = temp.key;
        temp.key = leftSum + rightSum;

        return c + temp.key;
    }

    // count leaves
    int countLeaves(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    /*    int countLeaves(Node node)
        {
            if(node == null)
                return 0;
            if(node.left == null && node.right == null)
                return 1;

            int l = countLeaves(node.left);
            int r = countLeaves(node.right);

            return l + r;
        }*/
    boolean isIdentical(Node root1, Node root2) {
        // Code Here
        if (root1 == null && root2 == null) return true;

        if (root1 != null && root2 != null)
            return (root1.key == root2.key && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));

        return false;


    }

    // check height balanced tree topdown approach
    static boolean checkBalanced(Node temp) {
        if (temp == null)
            return true;

        int h1 = heightOfTree(temp.left);
        int h2 = heightOfTree(temp.right);

        int out1 = h1 - h2;
        return (Math.abs(out1) <= 1 && checkBalanced(temp.left) && checkBalanced(temp.right));
    }


    // build height balanced binary tree
    static Node buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        Node root = new Node(arr[mid]);

        root.left = buildTree(arr, start, mid - 1);
        root.right = buildTree(arr, mid + 1, end);
        return root;
    }

    // create tree from preorder and inorder
    static int i = 0;

    static Node createTreeFromTrav(int[] in, int[] pre, int start, int end) {

        //base case
        if (start > end)
            return null;

        // recursive case
        Node root = new Node(pre[i]);

        int index = -1;
        for (int j = start; start <= end; j++) {
            if (in[j] == pre[i]) {
                index = j;
                break;
            }

        }
        i++;
        root.left = createTreeFromTrav(in, pre, start, index - 1);
        root.right = createTreeFromTrav(in, pre, index + 1, end);
        return root;
    }
/*
    Minimum element in BST
    int minValue(Node root)
    {
        if(root == null)
            return 0;

        if(root.left == null)
            return root.data;

        return minValue(root.left);
    }*/

/*    Size of Binary Tree
    public static int getSize(Node root)
    {
        if(root == null) return 0;

        return 1 + getSize(root.left) + getSize(root.right);
    }*/

/*    Height of Heap
    static int heapHeight(int N, int arr[]){

        return (int)Math.ceil( Math.log(N + 1) / Math.log(2)) - 1;

    }*/

/*    // max-heap
    static boolean isHeap(int arr[], int n) {
        // Start from root and go till the last internal
        // node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            // If right child is greater, return false
            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }*/

    /*Normal BST to Balanced BST
    Node buildBalancedTree(Node root)
    {
        List<Node> bstNodes = new ArrayList<>();

        storeBstNodes(root,bstNodes);
        return buildBalancedTreeUtil(bstNodes,0,bstNodes.size()-1);
    }

    void storeBstNodes(Node root,List<Node> bstNodes){
        if(root == null)
            return;

        storeBstNodes(root.left,bstNodes);
        bstNodes.add(root);
        storeBstNodes(root.right,bstNodes);
    }
    Node buildBalancedTreeUtil(List<Node> bstNodes,int low,int high){

        if(low > high)
            return null;

        int mid = (high + low) /2;
        Node node = bstNodes.get(mid);

        node.left = buildBalancedTreeUtil(bstNodes,low,mid-1);
        node.right = buildBalancedTreeUtil(bstNodes,mid+1,high);

        return node;
    }*/

    // Print all nodes that have no sibling
    /*void printSingles(Node node)
    {
        // Base case
        if (node == null)
            return;

        // If this is an internal node, recur for left
        // and right subtrees
        if (node.left != null && node.right != null)
        {
            printSingles(node.left);
            printSingles(node.right);
        }

        // If left child is NULL and right
        // is not, print right child
        // and recur for right child
        else if (node.right != null)
        {
            System.out.print(node.right.data + " ");
            printSingles(node.right);
        }

        // If right child is NULL and left
        // is not, print left child
        // and recur for left child
        else if (node.left != null)
        {
            System.out.print( node.left.data + " ");
            printSingles(node.left);
        }*/


    public static void main(String[] arg1) {

        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(44);
        root.left.left.left = new Node(44);

        root.right = new Node(9);
        root.right.right = new Node(22);

//        System.out.print(
//                "\nInorder traversal after insertion:");
//        inorder(root);
//
//        System.out.print(
//                "\nInorder traversal after insertion:");
//        inorder_iterative(root);
        System.out.print(
                "\nPostorder traversal:");
        postorder(root);
        System.out.print(
                "\nPostorder traversal:");
        postorder_iterative(root);

//        delete(root, key);
//        System.out.print(
//                "\nInorder traversal after delete:");
//        inorder(root);

//        System.out.print(
//                "\nPreorder traversal:");
//        preorder(root);
//        System.out.print(
//                "\nPostorder traversal:");
//        postorder(root);
//
//        System.out.println("\nlevel order traversal of tree : ");
//        levelOrder(root);
//        System.out.println("\nlevel order traversal iterative of tree : ");
//
//        levelOrderIterative(root);
//
//
//         /*  int h = heightOfTree(root);
//        int n = (int) Math.pow(2, h) - 1;
//        System.out.println(n);*/
//
//        System.out.println();
//        System.out.println("\ncount no. of nodes = " + countNodes(root));
//        System.out.println("sum no. of nodes = " + sumOfNodes(root));
//        System.out.println("diameter of tree = " + diameter(root));
//
//        System.out.println("\nlevel order traversal of tree before replacing : ");
//
//        inorder(root);
//
//        System.out.println("\nlevel order traversal of tree after replacing : ");
//        sumReplacement(root);
//        inorder(root);
//        System.out.println("\n");
//
//        preorder(root);
//        System.out.println("\n");
//
//        postorder(root);
//
//        System.out.println("\ncheck height balanced tree");
//        System.out.println(checkBalanced(root));

//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        root = buildTree(arr, 0, arr.length - 1);
//        levelOrder(root);

//        int[] in = {3, 2, 8, 4, 1, 6, 7, 5};
//        int[] pre = {1, 2, 3, 4, 8, 5, 6, 7};
//
//        root = createTreeFromTrav(in, pre, 0, in.length - 1);
//        levelOrder(root);
//        System.out.println();
//        delete(root, 2);
//        levelOrder(root);
//        inorder(root);

    }
}

