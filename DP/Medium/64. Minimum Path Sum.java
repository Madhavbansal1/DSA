// recursion
class Solution {
    public int minPathSum(int[][] grid) {
        return func(grid,0,0,grid.length-1,grid[0].length-1);
    }
    public int func(int[][] grid, int i, int j, int n, int m){
        if(i == n && j == m) return grid[i][j];
        if(i>n || j>m) return Integer.MAX_VALUE;

        return grid[i][j] + Math.min(func(grid,i+1,j,n,m),func(grid,i,j+1,n,m));
    }
}


// top-down


class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return func(grid,0,0,grid.length-1,grid[0].length-1,dp);
    }
    public int func(int[][] grid, int i, int j, int n, int m,int[][] dp){
        if(i == n && j == m) return grid[i][j];
        if(i>n || j>m) return Integer.MAX_VALUE;
        if(dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(func(grid,i+1,j,n,m,dp),func(grid,i,j+1,n,m,dp));
    }
}

// bottom-up
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int i=1; i<m; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
}
