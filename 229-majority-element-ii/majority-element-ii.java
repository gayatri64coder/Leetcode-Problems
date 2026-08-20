class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if(nums == null || nums.length ==0){
            return ans;
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr =0 ;
        //to get the frequency 
        for(int i =0 ; i< nums.length;i++){
            curr = nums[i];
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
        for(int i= 0 ; i< nums.length;i++){
            curr = nums[i];
            int count= map.get(curr);//get the freq of the key
            if(count > n/3  && !ans.contains(curr) ){
                ans.add(curr);
            }
        }
        return ans;
    }
}