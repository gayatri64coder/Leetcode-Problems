class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] a = str.toCharArray();
        int i = 0;
        int j = a.length -1;
        while(i < j){
            if(a[i] != a[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}