// recursion

class Solution {
    public int uniquePaths(int m, int n) {
        return func(1,1,m,n);
    }

    public int func(int i, int j, int m, int n){
        if(i>m || j>n){
            return 0;
        }
        if(i == m && j == n){
            return 1;
        }

        return func(i+1,j,m,n) + func(i,j+1,m,n);
    }
}

// top-down

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return func(0,0,m,n,dp);
        
    }

    public int func(int i, int j, int m, int n,int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i == m-1 && j == n-1){
            return 1;
        }

        return dp[i][j] =  func(i+1,j,m,n,dp) + func(i,j+1,m,n,dp);
    }
}

// bottom-up

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int up= 0;
                    int left = 0;
                    if(i-1>=0){
                        up = dp[i-1][j];
                    }
                    if(j-1>=0){
                        left = dp[i][j-1];
                    }

                    dp[i][j] = up+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
