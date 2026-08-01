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
    public boolean isSymmetric(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        left(root.left,l1);
        right(root.right,l2);

        return l1.equals(l2);
    }
    public void left(TreeNode root, List<Integer> l1)
    {
        if(root==null)
        {
            l1.add(null);
            return;
        }

        l1.add(root.val);
        left(root.left, l1);
        left(root.right, l1);
    }

    public void right(TreeNode root, List<Integer> l2)
    {
        if(root==null)
        {
            l2.add(null);
            return;
        }

        l2.add(root.val);
        right(root.right,l2);
        right(root.left,l2);
    }
    
}