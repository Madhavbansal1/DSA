class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        
        long sum1 = 0, sum2=0;
        int k=0,m=0;
        for(int i=0;i<nums1.length; i++){
            if(nums1[i] == 0){
                sum1 += 1;
                m++;
            }else{
                sum1 += nums1[i];
            }

        }
        for(int i=0;i<nums2.length; i++){
            if(nums2[i] == 0){
                sum2 += 1;
                k++;
            }else{
                sum2 += nums2[i];
            }

        }

        if (sum1 == sum2) {
            return sum1;
        } else {
            if (sum1 < sum2) {
                if (m > 0) {
                    return sum2;
                } else {
                    return -1;
                }
            } else {
                if (k > 0) {
                    return sum1;
                } else {
                    return -1;
                }
            }
        }
    }
}
