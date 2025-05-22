class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> ar = new ArrayList<>();
        coin(candidates,target,ar, arr,0);
        return arr;

    }
    public static void coin(int[] candidate, int target, List<Integer> ar,List<List<Integer>> arr,int start){
        if(start == candidate.length){
            if(target == 0){
                arr.add(new ArrayList<>(ar));
            }
            return;
        }

        if(target >= candidate[start]){
            ar.add(candidate[start]);
            coin(candidate,target-candidate[start],ar,arr,start);
            ar.remove(ar.size()-1);
        }
        coin(candidate,target,ar,arr,start+1);
    }
}
