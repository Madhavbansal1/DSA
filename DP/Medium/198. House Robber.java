// recursion

class Solution {
    public int rob(int[] nums) {
        return func(nums.length-1,nums);
    }

    public int func(int i, int[] nums){
        if(i<0) return 0;
        if(i == 0) return nums[0];

        int rob1 = nums[i]+func(i-2,nums);
        int rob2 = func(i-1,nums);

        return Math.max(rob1,rob2);
    }
}

// top-down

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        func(nums.length-1,nums,dp);
        return dp[nums.length-1];
    }

    public int func(int i, int[] nums,int[] dp){
        if(i<0) return 0;
        if(i == 0) return nums[0];

        if(dp[i] != -1){
            return dp[i];
        }
        int rob1 = nums[i]+func(i-2,nums,dp);
        int rob2 = func(i-1,nums,dp);

        return dp[i] = Math.max(rob1,rob2);
    }
}


// bottom-up
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++){
            int rob = dp[i-2]+nums[i];
            int noRob = dp[i-1];
            dp[i] = Math.max(rob,noRob);
        }

        return dp[nums.length-1];
    }
}
