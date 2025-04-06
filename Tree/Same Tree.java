class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q0 = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q0.add(p);
        q1.add(q);

        while (!q0.isEmpty() && !q1.isEmpty()) {
            TreeNode a = q0.poll();
            TreeNode b = q1.poll();

            
            if ((a == null && b != null) || (a != null && b == null) || (a != null && b != null && a.val != b.val)) {
                return false;
            }

            
            if (a != null) {
                q0.add(a.left);
                q0.add(a.right);
            }

            if (b != null) {
                q1.add(b.left);
                q1.add(b.right);
            }
        }

       
        return q0.isEmpty() && q1.isEmpty(); 
    }
}
