class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k){
            return -1;
        }
        int operation = 0;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                operation++;
            }
        }

        if(nums[0] == k){
            return operation;
        }

        return operation+1;
    }
}
