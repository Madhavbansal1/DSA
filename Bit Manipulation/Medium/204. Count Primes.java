class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1){
            return 0;
        }
        int count = 0;
        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;
        for(int i=2; i*i<=n; i++){
            if(prime[i] == false){
                for(int j = i*i; j<=n; j+=i){
                    prime[j] = true;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(prime[i] == false){
                count++;
            }
        }
        return count;
    }
}
