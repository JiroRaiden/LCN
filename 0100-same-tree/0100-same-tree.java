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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        inorderTraverse(tree1,p);
        inorderTraverse(tree2,q);
        return tree1.equals(tree2);
    }

    public void inorderTraverse(List<Integer> tree, TreeNode root)
    {
        if(root == null)
        {
            tree.add(null);
            return;
        }

        tree.add(root.val);
        inorderTraverse(tree, root.left);
        inorderTraverse(tree, root.right);
    }
}