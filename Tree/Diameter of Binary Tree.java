class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int sd = ht(root.left)+ht(root.right)+2;
        return Math.max(sd,Math.max(ld,rd));
    }

    public int ht(TreeNode root){
        if(root == null){
            return -1;
        }

        int l = ht(root.left);
        int r = ht(root.right);

        return Math.max(l,r)+1;
    }
}
