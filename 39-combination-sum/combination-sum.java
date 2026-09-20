class Solution {
    Set<List<Integer>> s = new HashSet<>();

    private void getComb(int[] nums,int i ,List<List<Integer>> ans, List<Integer> comb , int tar){
        if( i == nums.length || tar<0){
            return;
        }
        if(tar == 0){
            if( !s.contains(comb)){
                ans.add(new ArrayList<>(comb));
                s.add(new ArrayList<>(comb));
            }
            return;
        }

        comb.add(nums[i]);
        //single
        getComb(nums, i+1, ans, comb , tar - nums[i]);
        //multiple
        getComb(nums, i , ans, comb ,tar - nums[i]);
        //backtrack
        comb.remove(comb.size()-1);
        //not taken
        getComb(nums, i+1, ans, comb , tar);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        getComb(candidates, 0 ,ans, comb, target);
        return ans;
    }
}