class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans =0;
        int sum =0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0,1);//empty subarray
        for(int j =0 ; j< nums.length ; j++)
        {
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans+= map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return ans;
    }
}