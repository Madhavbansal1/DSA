class Solution {
    public boolean isBalanced(TreeNode root) {
        return Balanced(root);

    }
    public boolean Balanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean l = Balanced(root.left);
        boolean r= Balanced(root.right);
        boolean sb = Math.abs(ht(root.left)-ht(root.right))<=1;

        return l && r && sb;

    }
    public int ht(TreeNode node){
        if(node == null){
          
            return -1;

        }

        int l = ht(node.left);
        int r = ht(node.right);
        return Math.max(l,r)+1;
    }
}
