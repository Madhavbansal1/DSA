class Solution {
    public boolean isSymmetric(TreeNode root) {
       return  symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        boolean b1 = symmetric(root1.left,root2.right);
        boolean b2 = symmetric(root1.right,root2.left);
        return b1 && b2;
    }
}
