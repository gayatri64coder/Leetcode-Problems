class Solution {
    private void getAllPart(String s ,List<String> partition, List<List<String>> ans){
        //base case
        if(s.length() == 0){
            ans.add(new ArrayList<>(partition));
            return;
        }

        for(int i =0 ; i< s.length() ; i++){
            String part = s.substring(0, i+1);
            if(ispalindrome(part)){
                partition.add(part);
                getAllPart(s.substring(i+1), partition , ans); //recurse
                partition.remove(partition.size() -1); //backtrack
            }
        }
    }
    private boolean ispalindrome(String s){
        int i = 0;
        int j = s.length()-1 ;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        /*for(int i = 0 , j = s.length()-1 ; i <= j ; i++ ,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }*/
        return true;

    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        getAllPart(s,partition , ans);

        return ans;
        
    }
}