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

        for( int i =idx ; i< nums.length ;i++){

            int temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp ;
            getPerms(nums, idx+1 , result);

            int tem = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tem ;
            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPerms(nums, 0 , result);
        return result;
    }
}