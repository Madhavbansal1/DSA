class Solution {
    static class Cell{
        int row;
        int column;
        int effort;
        public Cell(int row, int column, int effort){
            this.row = row;
            this.column = column;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] diff = new int[n][m];

        for(int[] a: diff){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        diff[0][0] = 0;
        PriorityQueue<Cell> q = new PriorityQueue<>((a,b) -> a.effort - b.effort);
        q.add(new Cell(0,0,0));

        int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};

        while(!q.isEmpty()){
            Cell q1 = q.poll();
            int r1 = q1.row;
            int c1 = q1.column;
            int e = q1.effort;

            if(r1 == n-1 && c1 == m-1){
                return e;
            }

            for(int i=0; i<4; i++){
                int r = r1+dir[i][0];
                int c = c1+dir[i][1];
                if(r<n && r>=0 && c>=0 && c<m){
                    int efforts = Math.max(e,Math.abs(heights[r][c]-heights[r1][c1]));
                     if (efforts < diff[r][c]) {
                        diff[r][c] = efforts;
                        q.add(new Cell(r, c, efforts));
                    }
                }
                
            }
        }


        return 0;
    }
}
