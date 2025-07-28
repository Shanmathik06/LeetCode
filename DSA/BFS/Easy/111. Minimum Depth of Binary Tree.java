// Question : https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
 //bfs is faster than dfs
class Solution {
    public int minDepth(TreeNode root) {
        Queue <Object[]> q=new LinkedList<>();
        if(root==null){
            return 0;
        }
        q.add(new Object[]{root,1});
        while(!q.isEmpty()){
            
            for(int i=0;i<q.size();i++){
                Object []obj=q.poll();
                TreeNode node=(TreeNode)obj[0];
                int depth=(int)obj[1];
                if(node.left==null && node.right==null){
                    return depth;
                }
                if(node.left!=null){
                     q.add(new Object[]{node.left,depth+1});
                }
                if(node.right!=null){
                    q.add(new Object[]{node.right,depth+1});
                }   
            }
        }
      return 0;

    }
}
