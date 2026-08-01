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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        rightDFS(root,0,result);
        return result;
    }

    public void rightDFS(TreeNode root,int level, List<Integer> result)
    {
        if(root==null)
        return;

        if(result.size()==level)
        result.add(root.val);

        rightDFS(root.right, level+1, result);
        rightDFS(root.left, level+1, result);
    }
}