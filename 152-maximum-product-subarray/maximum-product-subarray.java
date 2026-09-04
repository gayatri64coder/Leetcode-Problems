class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0] ;
        for(int i =1 ;i < nums.length ;i++){
            int curr = nums[i];
            if( curr < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(curr , curr*min);
            max = Math.max(curr , curr * max);
            result =Math.max(result , max);
        }
        return result;
    }
}