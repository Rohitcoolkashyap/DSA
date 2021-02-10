package tree;

import java.util.LinkedList;
import java.util.Queue;

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

    // preorder traversal
    static void preorder(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.key + " ");
        preorder(temp.left);
        preorder(temp.right);
    }

    // postorder traversal
    static void postorder(Node temp) {
        if (temp == null)
            return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.print(temp.key + " ");
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

    public static void main(String[] arg1) {
/*        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(44);
        root.left.left.left = new Node(44);

        root.right = new Node(9);
        root.right.right = new Node(22);

        //root.right.right.right= new Node(52);


        System.out.print(
                "Inorder traversal before insertion:");
        inorder(root);
*//*
        int key = 12;
        insert(root, key);

        System.out.print(
                "\nInorder traversal after insertion:");
        inorder(root);*//*
         *//*


//        delete(root, key);
//        System.out.print(
//                "\nInorder traversal after delete:");
//        inorder(root);

        System.out.print(
                "\nPreorder traversal:");
        preorder(root);
        System.out.print(
                "\nPostorder traversal:");
        postorder(root);

        System.out.println("\nlevel order traversal of tree : ");
        levelOrder(root);
        System.out.println("\nlevel order traversal iterative of tree : ");

        levelOrderIterative(root);

      *//*
         *//*  int h = heightOfTree(root);
        int n = (int) Math.pow(2, h) - 1;
        System.out.println(n);*//**//*

        System.out.println();
        System.out.println("\ncount no. of nodes = " + countNodes(root));
        System.out.println("sum no. of nodes = " + sumOfNodes(root));
        System.out.println("diameter of tree = " + diameter(root));

        System.out.println("\nlevel order traversal of tree before replacing : ");

        inorder(root);

        System.out.println("\nlevel order traversal of tree after replacing : ");
        sumReplacement(root);
        inorder(root);
        System.out.println("\n");

        preorder(root);
        System.out.println("\n");

        postorder(root);
*//*
        System.out.println("\ncheck height balanced tree");
        System.out.println(checkBalanced(root));*/

//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        root = buildTree(arr, 0, arr.length - 1);
//        levelOrder(root);

        int[] in = {3, 2, 8, 4, 1, 6, 7, 5};
        int[] pre = {1, 2, 3, 4, 8, 5, 6, 7};

        root = createTreeFromTrav(in, pre, 0, in.length - 1);
        levelOrder(root);
        System.out.println();
        levelOrderIterative(root);
    }
}

