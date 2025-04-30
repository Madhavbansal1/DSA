class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            count += ((int)Math.log10(x))&1;
        }
        return count; 
    }
}
