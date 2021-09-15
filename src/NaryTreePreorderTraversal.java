import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

// Definition for a Node.
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        preorderHelper(root, preOrder);
        return preOrder;
    }

    private void preorderHelper(Node root, List<Integer> preOrder) {
        if (root == null) {
            return;
        }
        preOrder.add(root.val);
        for (Node child : root.children) {
            preorderHelper(child, preOrder);
        }
    }
}
