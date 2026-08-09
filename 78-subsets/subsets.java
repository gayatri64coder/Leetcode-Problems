class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int subsets = 1<<n;

        for(int num =0 ; num < subsets; num++){
            List<Integer> list = new ArrayList<>();
            for(int j =0 ;j < n; j++){
                if((num & (1 << j)) !=0){
                    list.add(nums[j]);
                }
            }
            result.add(list);
            
        }
        return result;
    }
}