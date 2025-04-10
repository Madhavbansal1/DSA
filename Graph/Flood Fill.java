class Solution {
    int[][] directions={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill(int[][] mat, int sr, int sc, int color) {
        int n=mat.length;
        int m=mat[0].length;
        int check = mat[sr][sc];
        if(check == color) return mat;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr, sc});
        mat[sr][sc] = color;
        while(!q.isEmpty())
        {
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                for(int[] dir:directions)
                {
                    int newR=row+dir[0];
                    int newC=col+dir[1];
                    if(newR>=0 && newR<n && newC>=0 && newC<m && mat[newR][newC]==check)
                    {
                        mat[newR][newC]=color;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            
        }
        return mat;
    }
}
