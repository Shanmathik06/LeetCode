//Question : https://leetcode.com/problems/same-tree/
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
     // BFS
      Queue <TreeNode> qu=new LinkedList<>();
      qu.add(p);
      qu.add(q);
      while(!qu.isEmpty()){
        TreeNode first=qu.poll();
        TreeNode second=qu.poll();
        if(first ==null && second==null){
            continue;
        }
        if(first==null ||  second==null || first.val!=second.val){
            return false;
        }
        qu.add(first.left);
        qu.add(second.left);
        qu.add(first.right);
        qu.add(second.right);
      }  
      return true;

    //DFS
    //  if(p==null && q==null){
    //         return true;
    //     }
    //     if(p==null ||  q==null || p.val!=q.val){
    //         return false;
    //     }
    //    boolean leftNode=isSameTree(p.left,q.left);
    //    boolean rightNode=isSameTree(p.right,q.right);
    //    return leftNode && rightNode;
    }
}
