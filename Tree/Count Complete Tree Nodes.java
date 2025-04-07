class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return count;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rv = q.poll();
            count++;
            if(rv.left != null){
                q.offer(rv.left);
            }
            if(rv.right != null){
                q.offer(rv.right);
            }
        }

        return count;
    }
}
