import java.util.*;

class Solution {
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // to prevent integer overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex; // normalize index to avoid overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
