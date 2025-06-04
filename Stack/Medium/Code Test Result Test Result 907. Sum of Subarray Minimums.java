class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ns = nsl(arr);
        int[] nr = nrl(arr);
        long sum = 0;

        for(int i=0; i<n; i++){
            long ls = i-ns[i];
            long rs = nr[i]-i;
            long total  =ls*rs;
            sum += (total*arr[i]);
            sum = sum%1000000007;
        }

        return (int) sum;
    }

    public static int[] nsl(int[] arr){
        Stack<Integer> a = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
        
                while(!a.isEmpty() && arr[i] <= arr[a.peek()]){
                    a.pop();
                }
                ans[i] = a.isEmpty() ? -1: a.peek();
            
            a.push(i);
        }

        return ans;
    }


     public static int[] nrl(int[] arr){
        Stack<Integer> a = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
           
                while(!a.isEmpty() && arr[i] < arr[a.peek()]){
                    a.pop();
                }
                ans[i] = a.isEmpty() ? arr.length: a.peek();
            
            a.push(i);
        }

        return ans;
    }
    
   
}
