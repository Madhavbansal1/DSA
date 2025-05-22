class Solution {
    public int countGoodNumbers(long n) {
        long ans1 = pow(5,(n+1)/2);
        long ans2 = pow(4,n/2);

        return (int)((ans1*ans2)%1000000007);
    }

    public long pow(long base,long n){
        if(n == 0) return 1;
        long half = pow(base,n/2);
        if(n%2 == 0){
            return (half*half)%1000000007;
        }else{
            return (half*half*base)%1000000007;
        }
    }

}
