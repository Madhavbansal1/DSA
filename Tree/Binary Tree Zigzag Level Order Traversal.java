class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i=0;
        while(!q.isEmpty()){
            int levelsize = q.size();
            List<Integer> a = new ArrayList<>();
            for(int j=0; j<levelsize; j++){
                TreeNode node = q.poll();
                a.add(node.val);

                if(node.left!=null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

            }
            if (i % 2 == 0) {
    res.add(a);
} else {
    Collections.reverse(a);
    res.add(a);
}
i++;

            
        }

        return res;


        
    }
}
