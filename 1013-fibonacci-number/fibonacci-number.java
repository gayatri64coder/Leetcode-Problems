class Solution {
    public int fib(int n) {
        int t1 = 0;
        int t2 = 1;
        int t3 =0;
        for(int i = 0; i< n ;i++){
            t3 = t1+t2;
            t2 = t1;
            t1 = t3;
        }
        return t3;
    }
}