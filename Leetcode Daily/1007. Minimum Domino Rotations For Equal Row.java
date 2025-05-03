class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = func(tops,bottoms,bottoms[0]);
        if(tops[0] != bottoms[0]){
            ans = Math.min(ans,func(tops,bottoms,tops[0]));
        }

        return ans == Integer.MAX_VALUE? -1: ans;
    }

    public int func(int[] tops, int[] bottoms, int target){
        int t = 0;
        int b = 0;
        for(int i=0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return Integer.MAX_VALUE;
            }
            if(tops[i] != target) t++;
            if(bottoms[i] != target) b++;
        }

        return Math.min(t,b);

    }
}
