class Solution {
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
