class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,ArrayList<Integer>> a  = new HashMap<>();
        for(int i=1; i<=isConnected.length; i++){
            a.put(i,new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    a.get(i+1).add(j+1);
                }
            }
        }
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int src: a.keySet()) {
            if (visited.contains(src)) {
                
                continue;
            }
            count++;
            q.offer(src);
            while (!q.isEmpty()) {
                // 1. remove
                int rm = q.poll();
                // 2. ignore if already visited
                if (visited.contains(rm)) {
                    continue;
                }
                // 3. marked visited
                visited.add(rm);

                // 4. self worked
               // System.out.print(rm + " ");

                // 5. add nbrs

                for (int nbr : a.get(rm)) {
                    if (!visited.contains(nbr)) {
                        q.offer(nbr);
                    }
                }
               // System.out.println();
            }

       }
       return count;
    }
}
