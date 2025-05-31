class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subset = new ArrayList<>();
        for(int num = 0; num < (1<<n); num++){
            List<Integer> sub = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if((num & (1<<i)) != 0){
                    sub.add(nums[i]);
                }
            }

            subset.add(sub);


        }

        return subset;
    }
}
