import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }

        if(sum % 2 != 0) return false;

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return canAchieve(nums, target, 0, dp) == 1;
    }

    private int canAchieve(int[] nums, int target, int idx, int[][] dp) {
        if (target == 0) return 1;
        if (idx >= nums.length) return 0;
        if (dp[idx][target] != -1) return dp[idx][target];

        int include = 0;
        if (target >= nums[idx]) {
            include = canAchieve(nums, target - nums[idx], idx + 1, dp);
        }
        int exclude = canAchieve(nums, target, idx + 1, dp);

        dp[idx][target] = (include + exclude > 0) ? 1 : 0;
        return dp[idx][target];
    }
}
