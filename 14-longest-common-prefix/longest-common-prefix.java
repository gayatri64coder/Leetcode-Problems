//vertical : Builder strategy
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ){
            return "";
        }
        String curr = strs[0];

        
        for( int i = 1 ; i< strs.length ;i++){
            String n = strs[i];
            int j = 0;
            
            while(  j < curr.length() && j < n.length() && curr.charAt(j) == n.charAt(j) ){
                j++;
            }  
            curr = curr.substring(0,j);   
            if (curr.isEmpty()) return "";
        }
        return curr;
        
    }
}