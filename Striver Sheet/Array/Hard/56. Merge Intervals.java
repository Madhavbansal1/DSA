import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0; 
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        
        int[] res = new int[max * 2 + 4];
        for (int i = 0; i < intervals.length; i++) {
            res[intervals[i][0]*2]++;
            res[intervals[i][1]*2+1]--;
        }
        
        int[] pre = new int[max * 2+ 4]; 
        pre[0] = res[0];
        for (int i = 1; i < max * 2 + 4; i++) {
            pre[i] = pre[i - 1] + res[i];
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < max *2 + 4; i++) {
            if (flag == 0) {
                if (pre[i] > 0) {
                    flag = 1;
                    arr.add(i/2);
                }
            }
            if (flag == 1) {
                if (pre[i] == 0) {
                    flag = 0;
                    arr.add(i/2);
                }
            }
        }
        
      
        if (arr.size() % 2 != 0) {
            arr.add(max);
        }
        
        int[][] mer = new int[arr.size() / 2][2];
        int k = 0;
        for (int i = 0; i < mer.length; i++) {
            for (int j = 0; j < 2; j++) {
                mer[i][j] = arr.get(k++);
            }
        }

        return mer;
    }
}
