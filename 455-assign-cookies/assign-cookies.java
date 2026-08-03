 //two pointer approach  
 class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int l  =0;
        int r =0 ;
        int n = g.length; //right pointer 
        int m = s.length; //left pointer

        Arrays.sort(g);
        Arrays.sort(s);

        while(r < m && l< n){
            if(g[l] <= s[r]){
                l= l+1;
            }
            r= r+1;
        }
        return l;
        
    }
}