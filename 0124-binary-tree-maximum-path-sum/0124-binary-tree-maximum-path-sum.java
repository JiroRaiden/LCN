/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0]= Integer.MIN_VALUE;
        findMaxSum(maxSum, root);
        return maxSum[0];
    }

    public int findMaxSum(int[] maxSum, TreeNode root )
    {
        if(root == null)
        return 0;

        int left = Math.max(0,findMaxSum(maxSum,root.left));
        int right = Math.max(0,findMaxSum(maxSum,root.right));

        maxSum[0] = Math.max(maxSum[0], ( left + right) + root.val);
        return root.val + Math.max(left, right);
    }
}