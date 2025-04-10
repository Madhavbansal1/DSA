class Solution {
    int[][] directions={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private boolean solved(int[][] mat, int n, int m)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1) return false;
            }
        }
        return true;
    }
    public int orangesRotting(int[][] mat) {
        // Code here
        int n=mat.length;
        int m=mat[0].length;
        if(solved(mat, n, m)) return 0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==2) q.add(new int[]{i, j});
            }
        }
        int time=0;
        while(!q.isEmpty())
        {
            time++;
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
                    if(newR>=0 && newR<n && newC>=0 && newC<m && mat[newR][newC]==1)
                    {
                        mat[newR][newC]=2;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            if(solved(mat, n, m)) return time;
        }
        return -1;
    }
}
