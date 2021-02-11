package testing;


import java.util.ArrayList;
import java.util.List;

class GfG {
    static Node root;

    static class Node {
        int data;
        Node right, left;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static List<Node> bstNodes = new ArrayList<>();

    static Node buildBalancedTree(Node root) {
        storeBstNodes(root);
        return buildBalancedTreeUtil(root, 0, bstNodes.size() - 1);

    }

    static void storeBstNodes(Node root) {
        if (root == null)
            return;

        storeBstNodes(root.left);
        bstNodes.add(root);
        storeBstNodes(root.right);
    }

    static Node buildBalancedTreeUtil(Node root, int low, int high) {

        if (low > high)
            return null;

        int mid = (high + low) / 2;
        Node node = bstNodes.get(mid);

        node.left = buildBalancedTreeUtil(root.left, low, mid - 1);
        node.right = buildBalancedTreeUtil(root.right, mid + 1, high);

        return node;
    }

    public static void main(String[] arg){

    }
}