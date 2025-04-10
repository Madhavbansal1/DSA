class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0][0];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int[] ce = q.poll();
            int r = ce[0];
            int c = ce[1];

            for(int i=0; i<4; i++){
                int r1 = r+dir[i][0];
                int c1 = c+dir[i][1];
                if(r1>=0 && r1<mat.length && c1>=0 && c1<mat[0].length && mat[r][c]+1<mat[r1][c1]){
                    q.add(new int[]{r1,c1});
                    mat[r1][c1] = mat[r][c]+1;
                }
            }
        }

        return mat;
    }
}
