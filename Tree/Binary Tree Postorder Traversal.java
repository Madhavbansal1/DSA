class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        func(ans,root);
        return ans;
        
    }

    public void func(List<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }
        func(ans,root.left);
        func(ans,root.right);
        ans.add(root.val);
        return;
    }
}
