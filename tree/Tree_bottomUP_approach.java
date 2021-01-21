package tree;

public class Tree_bottomUP_approach {
    static BinaryTree.Node root;


    // height balanced Tree
    static class HBPair {
        int height;
        boolean balance;

        HBPair() {
            height = 0;
            balance = true;
        }
    }

    // bottom up appraoch
    static HBPair heightBalancedTree(BinaryTree.Node root) {
        HBPair p = new HBPair();
        if (root == null) {
            p.height = 0;
            p.balance = true;
            return p;
        }
        // recursive case
        HBPair left = heightBalancedTree(root.left);
        HBPair right = heightBalancedTree(root.right);

        p.height = Math.max(left.height, right.height) + 1;

        p.balance = (Math.abs(left.height - right.height) <= 1 &&
                left.balance && right.balance);
        return p;
    }

    /* topdown appraoch
    public boolean isBalanced(TreeNode temp) {
        if (temp == null)
            return true;

        int h1 = heightOfTree(temp.left);
        int h2 = heightOfTree(temp.right);

        int out1 = h1 - h2;
        return (Math.abs(out1) <= 1 && isBalanced(temp.left) && isBalanced(temp.right));
    }*/

    public static void main(String[] arg) {
        root = new BinaryTree.Node(10);
        root.left = new BinaryTree.Node(5);
        root.right = new BinaryTree.Node(7);

        System.out.println("\ncheck height balanced tree : " + heightBalancedTree(root).balance);
    }
}
