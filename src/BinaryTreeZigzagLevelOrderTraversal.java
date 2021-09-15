import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = levelOrder(root);
        boolean flag = false;
        for (List<Integer> l : levels) {
            if (flag) {
                Collections.reverse(l);
            }
            flag = !flag;
        }
        return levels;
    }
    
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        levelOrderHelper(root, levels, 0);
        return levels;
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> levels, int index) {
        if (root != null) {
            if (index + 1 > levels.size()) {
                List<Integer> currLevel = new ArrayList<>();
                levels.add(currLevel);
            }
            levels.get(index).add(root.val);
            levelOrderHelper(root.left, levels, index + 1);
            levelOrderHelper(root.right, levels, index + 1);
        }
    }
}
