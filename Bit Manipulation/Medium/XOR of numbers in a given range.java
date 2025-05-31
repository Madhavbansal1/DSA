class Solution {
    public int findRangeXOR(int l, int r) {
         //your code goes here
         return xor(l-1) ^ xor(r);
    }

    public int xor(int n){
        if(n%4 == 0) return n;
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        
        return 0;
    }
}
