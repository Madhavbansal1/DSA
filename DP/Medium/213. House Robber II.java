// recursion
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(func(nums,0,nums.length-2),func(nums,1,nums.length-1));
    }
    public int func(int[] nums,int i, int j){
        if(i>j) return 0;

        int rob = nums[i] + func(nums,i+2,j);
        int skip = func(nums,i+1,j);

        return Math.max(rob,skip);
    }
}

// top-down 
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp2 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp2,-1);
        Arrays.fill(dp1,-1);
        return Math.max(func(nums,0,nums.length-2,dp2),func(nums,1,nums.length-1,dp1));
    }
    public int func(int[] nums,int i, int j,int[] dp){
        if(i>j) return 0;
        if(dp[i] != -1) return dp[i];
        int rob = nums[i] + func(nums,i+2,j,dp);
        int skip = func(nums,i+1,j,dp);

        return dp[i] = Math.max(rob,skip);
    }
}

// bottom-up

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    
    private int robRange(int[] nums, int l, int r) {
        int n = r - l + 1;
        int[] dp = new int[n];
        dp[0] = nums[l];
        if(n == 1) return dp[0];

        dp[1] = Math.max(nums[l], nums[l + 1]);

        for(int i = 2; i < n; i++) {
            int rob = dp[i - 2] + nums[l + i];
            int skip = dp[i - 1];
            dp[i] = Math.max(rob, skip);
        }

        return dp[n - 1];
    }
}
