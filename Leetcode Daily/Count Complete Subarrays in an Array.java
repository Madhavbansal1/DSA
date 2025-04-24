class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int distant = set.size();
        for (int i = 0; i < nums.length; i++) {
            set.clear(); 
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if(set.size()==distant){
                    count++;
                }
            }
        }
        return count;
    }
}
