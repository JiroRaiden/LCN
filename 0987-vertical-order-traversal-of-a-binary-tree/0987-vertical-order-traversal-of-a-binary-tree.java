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

    class Point{
        int x;
        int y;
        int val;

        Point(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        return result;

        List<Point> points = new ArrayList<>();
        //Flatten List
        dfs(root,0,0,points);

        //Custom sorting using custom comparator

        Collections.sort(points, (a,b) -> {
            if(a.x!=b.x)
            return Integer.compare(a.x,b.x);

            if(a.y!=b.y)
            return Integer.compare(a.y,b.y);

            return Integer.compare(a.val,b.val);
        });

        //Group and Add to result list

        Integer currX = null;
        List<Integer> currColumn = null;
        for(Point point:points)
        {
            if(currX==null||point.x!=currX)
            {
                currColumn = new ArrayList<>();
                result.add(currColumn);
                currX = point.x;
            }

            currColumn.add(point.val);
        }
        return result;

    }

    public void dfs(TreeNode root, int x, int y, List<Point> points)
    {
        if(root== null)
        return;

        points.add(new Point(x,y,root.val));
        dfs(root.left,x-1,y+1,points);
        dfs(root.right,x+1,y+1,points);
    }
}