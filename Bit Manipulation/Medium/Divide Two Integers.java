class Solution {
    public int divide(int divi, int di) {
        if (divi == di) return 1;

        
        if (divi == Integer.MIN_VALUE && di == -1) return Integer.MAX_VALUE;

    
        long dividend = Math.abs((long) divi);
        long divisor = Math.abs((long) di);

        int ans = 0;
        while (dividend >= divisor) {
            int count = 0;
            while (dividend >= (divisor << (count + 1))) {
                count++;
            }
            ans += (1 << count);
            dividend -= (divisor << count);
        }

        
        boolean isNegative = (divi > 0) ^ (di > 0);

        return isNegative ? -ans : ans;
    }
}
