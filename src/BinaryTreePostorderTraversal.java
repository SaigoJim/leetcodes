import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
*/
public class BinaryTreePostorderTraversal {
    /** Definition for a binary tree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        postorderTraversalHelper(root, postOrder);
        return postOrder;
    }
    private void postorderTraversalHelper(TreeNode node, List<Integer> postOrder) {
        if (node == null) {
            return;
        }
        postorderTraversalHelper(node.left, postOrder);
        postorderTraversalHelper(node.right, postOrder);
        postOrder.add(node.val);
    }
    public List<Integer> postorderTraversalWithStack(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        Stack<TreeNode> fringe = new Stack<>();
        fringe.push(root);
//        while ()
        return postOrder;
    }
}
