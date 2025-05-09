class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        func(root,ans);

        return ans;
    }

    public void func(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }

        func(root.left,ans);
        ans.add(root.val);
        func(root.right,ans);
    }
}
