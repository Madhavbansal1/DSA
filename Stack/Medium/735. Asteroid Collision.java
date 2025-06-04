class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ar = new Stack<>();
        for(int a: asteroids){
            if(a>0){
                ar.push(a);
            }else{
                while(!ar.isEmpty() && (-1)*a > ar.peek() && ar.peek()>0){
                    ar.pop();
                }
                if(ar.isEmpty() || ar.peek()<0){
                    ar.push(a);
                }else if((-1)*a == ar.peek()){
                    ar.pop();
                }
            }
        }

        int[] ans = new int[ar.size()];
        int i= ar.size()-1;
        while(!ar.isEmpty()){
            ans[i--] = ar.pop();
        }

        return ans;
    }
}
