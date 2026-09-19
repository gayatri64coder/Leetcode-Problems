class Solution {
    private void printSubsets(int[] nums ,List<List<Integer>> result,List<Integer> ans, int i ){
        if( i== nums.length){
            result.add(new ArrayList<>(ans));
            return ;
        }
        //include
        ans.add(nums[i]);
        printSubsets(nums,result, ans ,i+1);

        //backtrack
        ans.remove(ans.size() -1);
        //exclude
        printSubsets(nums,result,ans , i+1);


        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        printSubsets(nums, result , ans, 0);
        return result;
    }
}