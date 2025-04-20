class Solution {
    class Union{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        public  Union(int n){
            for(int i=0; i<n; i++){
                rank.add(0);
                parent.add(i);
            }

            
        }

        public int findParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ultimateParent = findParent(parent.get(node));
            parent.set(node,ultimateParent);
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int parentU = findParent(u);
            int parentV = findParent(v);
            if(parentU == parentV){
                count++;
                return;
            }
            int rankU = rank.get(parentU);
            int rankV = rank.get(parentV);
            
            if(rankU < rankV){
                parent.set(parentU,parentV);
            }else if(rankU > rankV){
                parent.set(parentV,parentU);
            }else{
                parent.set(parentV,parentU);
                rank.set(parentU,rankU+1);
            }
            count1++;
            return;
        }

    }
    public int makeConnected(int n, int[][] connections) {
        Union u= new Union(n);
        for(int i=0; i<connections.length; i++){
            u.unionByRank(connections[i][0],connections[i][1]);
        }

        
        int mini = u.count + u.count1;
        
        if(mini >= n-1){
            mini = mini - (n-1);
            
            return u.count - mini;
        }

        return -1;

    }
}
