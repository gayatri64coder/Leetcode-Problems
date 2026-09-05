class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length -1);
        return nums;
    }
    private void divide(int[] nums , int start , int end){
        
        if(start < end){
            int mid = start +(end-start) /2;
            divide(nums, start , mid);
            divide (nums, mid+1 , end);

            conquer(nums , start , mid, end);
        }
    } 
    private void conquer(int[] nums , int start , int mid, int end){
        int[] temp = new int[nums.length];
        int i = start;
        int j = mid+1;
        int k =0 ;

        while(i<= mid && j<= end){
            if(nums[i] <nums [j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }
        while(i<= mid){
            temp[k++] = nums[i++];
        }
        while(j <=end){
            temp[k++] = nums[j++];
        }
        for( i = start, k =0; i <= end ;i++, k++){
            nums[i] = temp[k];
        }
    }
   
}