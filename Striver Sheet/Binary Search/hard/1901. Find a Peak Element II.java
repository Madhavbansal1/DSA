public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = mat[i][j];

                boolean up = i == 0 || mat[i - 1][j] < val;
                boolean down = i == rows - 1 || mat[i + 1][j] < val;
                boolean left = j == 0 || mat[i][j - 1] < val;
                boolean right = j == cols - 1 || mat[i][j + 1] < val;

                if (up && down && left && right) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1}; // Not expected to happen
    }
}
