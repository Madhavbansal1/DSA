class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        func(ans,"",0,0,n);
        return ans;
    }
    public void func(List<String> ans, String s, int open, int close,int n){
        if((open == n) && (close == n)){
            ans.add(s);
            return;
        }

        if(open<n){
            func(ans,s+"(",open+1,close,n);
        }
        if(close<open){
            func(ans,s+")",open,close+1,n);
        }
    }
}
