class Solution {
     private void getPerms(int[] nums , int idx ,List<List<Integer>> result ){
        if( idx == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int num : nums){
                curr.add(num);
            }
            result.add(curr);
            return ;
        }
        Set<Integer> exchanged = new HashSet<>();
        for( int i =idx ; i< nums.length;i++){
            
            if(exchanged.contains(nums[i])){
                continue;
            } 
            exchanged.add(nums[i]);
            
            swap(nums, idx,i);
            getPerms(nums, idx+1 , result);
            swap(nums, idx , i);
        }
    }
    private void swap(int[] nums , int idx, int i){
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp ;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getPerms(nums, 0 , result);
        return result;
    }
}