// recursion

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       return  func(nums,0,target,0);
    }
    public int func(int[] nums, int i, int target, int sum){
        if(i == nums.length){
            return sum == target ? 1: 0;
        }

        int a = func(nums,i+1,target,sum+nums[i]);
        int b = func(nums,i+1,target,sum-nums[i]);

        return a+b;
    }
}

// top-down

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
         for(int i: nums){
            total += i;
         }

         if(target > total) return 0;
         int offset = total;
        int[][] dp = new int[nums.length][2*total+1];
        for(int i=0;i<nums.length; i++){
            Arrays.fill(dp[i],-1);
        }
       return  func(nums,0,target,0,dp,offset);
    }
    public int func(int[] nums, int i, int target, int sum,int[][] dp,int offset){
        if(i == nums.length){
            return sum == target ? 1: 0;
        }
        if(dp[i][sum+offset] != -1){
            return dp[i][sum+offset];
        }
        int a = func(nums,i+1,target,sum+nums[i],dp,offset);
        int b = func(nums,i+1,target,sum-nums[i],dp,offset);

        return dp[i][sum+offset] = a+b;
    }
}
