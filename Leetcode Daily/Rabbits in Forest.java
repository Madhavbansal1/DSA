import java.util.*;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

       
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

   
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();    
            int count = entry.getValue(); 
            int groupSize = x + 1;
            
            
            int groups = (int) Math.ceil((double) count / groupSize);
            
            total += groups * groupSize;
        }

        return total;
    }
}
