import java.util.*;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Check if start or end is blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        // Directions for 8 possible movements
        int[][] directions = {
            {1, 0}, {0, 1}, {1, 1},
            {-1, 0}, {0, -1}, {-1, -1},
            {1, -1}, {-1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // {x, y, pathLength}
        grid[0][0] = 1; // mark as visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            if (x == n - 1 && y == n - 1) return dist;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY, dist + 1});
                    grid[newX][newY] = 1; // mark visited
                }
            }
        }

        return -1;
    }
}
