class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int c = ( a & b ) << 1; // sum with carry
            a = a^b; //sum without carry
            b = c;
        }
        return a;
    }
}