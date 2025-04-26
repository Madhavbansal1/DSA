

// using mcm 
class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = arr[arr.length-1] = 1;
        for(int i=1; i<arr.length-1; i++){
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[arr.length+1][arr.length+1];

        return maximum_coins(arr,0,arr.length-1,dp);
    }

    public static int maximum_coins(int[] a, int i, int j,int[][] dp){

        if(i+1 == j){
            return 0;
        }
        int ans = Integer.MIN_VALUE;

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        for(int k=i+1; k<j; k++){
            int left = maximum_coins(a,i,k,dp);
            int right = maximum_coins(a,k,j,dp);
            int self = a[i]*a[k]*a[j];
            ans = Math.max(left+right+self,ans);
        }

        return dp[i][j]=ans;
    }
}
