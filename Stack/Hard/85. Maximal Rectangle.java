class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int ans = 0;
        for(int i = matrix.length-1; i>=0; i--){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }
            ans = Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }
    
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> a = new Stack<>();
        int h=0;
        int r=0;
        int l=0;
        int area = 0;
        for(int i=0; i<arr.length; i++){
            while(!(a.isEmpty()) && arr[i]<arr[a.peek()]){
                h = arr[a.pop()];
                r = i;
                if(!(a.isEmpty())){
                    l = a.peek();
                    area = Math.max(area,h*(r-l-1));
                }else{
                    area = Math.max(area,h*r);
                }

            }
            a.push(i);
            
        }
        r= arr.length;
        while(!(a.isEmpty())){
                h = arr[a.pop()];
                if(!(a.isEmpty())){
                    l = a.peek();
                    area = Math.max(area,h*(r-l-1));
                }else{
                    area = Math.max(area,h*r);
                }
        }
        return area;
        
    }

}
