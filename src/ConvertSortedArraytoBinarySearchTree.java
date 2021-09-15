import org.junit.Test;
import static org.junit.Assert.*;

public class ConvertSortedArraytoBinarySearchTree {
     public static class TreeNode {
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
    public TreeNode sortedArrayToBST(int[] nums) {
         if (nums.length == 1) {
             return new TreeNode(nums[0]);
         } else if (nums.length == 0) {
             return null;
         }
         int median = nums.length / 2;
         TreeNode t = new TreeNode(nums[median]);
         int[] left = new int[median];
         int[] right = new int[nums.length - left.length - 1];
         System.arraycopy(nums, 0, left, 0, median);
         System.arraycopy(nums, median + 1, right, 0, right.length);
         t.left = sortedArrayToBST(left);
         t.right = sortedArrayToBST(right);
         return t;
    }
    @Test
    public void testConvert() {
         int[] arr0 = new int[]{-10,-3,0,5,9};
         TreeNode t = sortedArrayToBST(arr0);
    }


}
