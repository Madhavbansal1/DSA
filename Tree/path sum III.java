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
    
    public int pathSum(TreeNode root, int targetSum) {
        return path(root,targetSum);
    }
    public int path(TreeNode root, long targetSum) {
        if(root==null){
            return 0;
        }

        int c = countPath(root,targetSum);

        int l = path(root.left,targetSum);
        
        int r = path(root.right,targetSum);
        return l + c + r;
        
    }
    public int countPath(TreeNode root,long target){
        if(root==null)return 0;
        int count = 0;
        if(root.val-target==0){
            count++;
        }
        int left = countPath(root.left,target-root.val);
        int right = countPath(root.right,target-root.val);
        return left + right + count;

    }
}
