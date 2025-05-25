class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if (k >= n && k >= m) {
            return 0;
        } else if (n > k) {
            return (long) k * (n - k);
        } else {
            return (long) k * (m - k);
        }
    }
}
