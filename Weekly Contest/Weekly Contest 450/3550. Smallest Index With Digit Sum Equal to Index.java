class Solution {
    public int smallestIndex(int[] nums) {
       
        for(int i=0; i<nums.length; i++){
            if(i == sumOfDigits(nums[i])) return i;
        }

        return -1;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
