class Solution {
    public int minBitFlips(int start, int goal) {
        int ans =0 ;
        int count =0;

        ans = start^ goal;
        while(ans!= 0){
            ans = ans &(ans-1);
            count++;
        }
        return count;

    }
}