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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        int[] count = new int[1];
        findKthSmallest(root,k,count,ans);
        return ans[0];
    }
    public void findKthSmallest(TreeNode root, int k, int[] count,int[] ans)
    {
        if(root == null)
        return;

        findKthSmallest(root.left,k,count,ans);

        if(++count[0]==k)
        ans[0]=root.val;

        findKthSmallest(root.right,k,count,ans);
    }
}