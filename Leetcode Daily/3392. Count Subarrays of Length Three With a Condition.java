class Solution {
    public int countSubarrays(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int count = 0;
        for(int i=0; i<=nums.length-3; i++){
            int sum = nums[i]+nums[i+2];
            if(nums[i+1] == sum*2){
                count++;
            }
        }

        return count;
    }
}
