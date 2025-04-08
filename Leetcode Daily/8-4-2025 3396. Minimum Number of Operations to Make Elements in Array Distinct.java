class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count = 0;
        int j = 0;
        while (!fun(map)) {
            for (int i = j; i < j + 3 && i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                    }
                }
            }
            count++;
            j += 3;
        }

        return count;
    }

    public boolean fun(HashMap<Integer,Integer> map){
        for(int i: map.values()){
            if(i>1){
                return false;
            }
        }

        return true;
    }
}
