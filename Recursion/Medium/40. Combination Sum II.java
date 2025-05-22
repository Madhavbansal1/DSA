class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> ar = new ArrayList<>();
        Arrays.sort(candidates); 
        coin(candidates, target, ar, arr, 0);
        return arr;
    }

    public static void coin(int[] candidate, int target, List<Integer> ar, List<List<Integer>> arr, int start) {
        if (target == 0) {
            arr.add(new ArrayList<>(ar));
            return;
        }

        for (int i = start; i < candidate.length; i++) {
      
            if (i > start && candidate[i] == candidate[i - 1]) continue;

        
            if (candidate[i] > target) break;

            ar.add(candidate[i]);
            coin(candidate, target - candidate[i], ar, arr, i + 1); 
            ar.remove(ar.size() - 1);
        }
    }
}
