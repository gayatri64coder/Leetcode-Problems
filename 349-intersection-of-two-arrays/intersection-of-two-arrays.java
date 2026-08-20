class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> arr = new HashSet<>();
        
        for(int i =0 ; i< nums1.length;i++){
            ans.add(nums1[i]);
        }
        for(int j = 0; j< nums2.length ;j++){
            if(ans.contains(nums2[j])){
                arr.add(nums2[j]);
                ans.remove(nums2[j]);
            } 
        }
        int[] result = new int[arr.size()];
        int k=0; 
        for(int num : arr){
            result[k] = num;
            k++;
        }
        return result;
  
    }
}