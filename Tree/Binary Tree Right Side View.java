class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode rv = q.poll();
                result.add(rv.val);
                if(rv.left != null) q.offer(rv.left);
                if(rv.right != null) q.offer(rv.right);
            }
            ans.add(result);

        }

        List<Integer> ans1 = new ArrayList<>();
        for(int i=0; i<ans.size(); i++){
            List<Integer> a = ans.get(i);
            ans1.add(a.get(a.size()-1));
        }

        return ans1;
    }
}
