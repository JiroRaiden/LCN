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
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,new int[]{0},Integer.MAX_VALUE);
    }
    public TreeNode construct(int[] preorder, int[] i , int max)
    {
        if(i[0]>=preorder.length || preorder[i[0]]>max) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = construct(preorder, i, root.val);
        root.right = construct(preorder, i, max);

        return root;

    }
}