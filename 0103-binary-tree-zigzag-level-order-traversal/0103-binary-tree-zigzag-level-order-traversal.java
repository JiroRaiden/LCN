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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        return result;

        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        boolean leftToRight = false;

        while(!(q.isEmpty()))
        {
            int n = q.size();
            LinkedList<Integer> curr = new LinkedList<>();

            for(int i = 0;i<n ;i++)
            {
                TreeNode temp = q.poll();

                if(leftToRight)
                    curr.addFirst(temp.val);
                else
                    curr.addLast(temp.val);

                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);

            }
            result.add(curr);
            leftToRight = !leftToRight;

        }
        return result;
    }
}