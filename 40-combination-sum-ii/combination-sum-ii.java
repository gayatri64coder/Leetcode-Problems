class Solution {

    private void allComb(int [] nums, int idx , List<List<Integer>> ans , List<Integer> comb ,int tar){
        if(tar == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(idx == nums.length || tar < 0){
            return ;
        }
        if( nums[idx] > tar){
            return;
        }
        comb.add(nums[idx]);
        //recurse
        allComb(nums,idx+1 ,ans ,comb , tar - nums[idx]);
        //backtrack
        comb.remove(comb.size()-1);
        while( idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        allComb(nums,idx+1 ,ans ,comb , tar);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        allComb(candidates , 0 , ans, result , target);
        return ans;
    }
}