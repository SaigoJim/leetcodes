public class InvertBinaryTree {
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempLeft = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tempLeft;
        return root;
    }
}
