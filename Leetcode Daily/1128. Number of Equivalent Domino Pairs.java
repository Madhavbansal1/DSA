import java.util.*;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int[] domino : dominoes) {
            // Normalize: smaller number first, larger second
            int a = domino[0];
            int b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a;  // Unique key for pair

            // Count pairs formed with existing dominoes
            count += map.getOrDefault(key, 0);

            // Update map count
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return count;
    }
}
