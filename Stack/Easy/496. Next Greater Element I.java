class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        map.put(nums[nums.length-1],-1);
        st.push(nums[nums.length-1]);
        for(int i=nums.length-2; i>=0; i--){
            while(!st.isEmpty()){
                if(st.peek()>nums[i]){
                    map.put(nums[i],st.peek());
                    st.push(nums[i]);
                    break;
                }else{
                    st.pop();
                }
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],-1);
                st.push(nums[i]);
            }
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;

    }
}
