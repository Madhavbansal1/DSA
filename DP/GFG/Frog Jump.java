// User function Template for Java
// top-down
class Solution {
    int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        ans(height.length-1, height,dp);
        return dp[height.length-1];
    }
    int ans(int i, int[] nums,int[] dp){
        if(i == 0) return 0;
        
        if(dp[i] != 0){
            return dp[i];
        }
        int one = ans(i-1,nums,dp) + Math.abs(nums[i] - nums[i-1]);
        int two = Integer.MAX_VALUE;
        if(i >= 2){
            two = ans(i-2,nums,dp) + Math.abs(nums[i] - nums[i-2]);
        }
        
        return dp[i] = Math.min(one,two);
    }
}


// bottom-up

// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int[] dp  = new int[height.length];
        for(int i = 1; i<height.length; i++){
            int one = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int two = Integer.MAX_VALUE;
            if(i>= 2){
                two = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            
            dp[i] = Math.min(one,two);
        }
        
        return dp[height.length-1];
    }
}
