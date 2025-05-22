// bit manipulation

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

// recursion

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        generatesubset(nums,new ArrayList<>(),subset,0);
        return subset; 
    }
    public static void generatesubset(int[] nums, List<Integer> sub,List<List<Integer>> subset,int start){
        subset.add(new ArrayList<>(sub));
        for(int i = start; i<nums.length; i++){
            sub.add(nums[i]);
            generatesubset(nums,sub,subset,i+1);
            sub.remove(sub.size()-1);
        }
    }
    

}
