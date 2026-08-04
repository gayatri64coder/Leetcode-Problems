/*class Solution {
    private int count(String number , int result, int len , int i ){
        if(i >= len){
            return result;
        }
        if(i % 2 == 0 ){
            char ch = number.charAt(i);
            int num = ch -'0';
            if(num %2 ==0){
                result++;
            }
            i++;
        }else{
            char ch = number.charAt(i);
            int num = ch -'0';
            if(num == 2|| num == 3 || num==5 || num == 7){
                result++;
            }
            i++;
        }
        result = count(number , result , len , i);
        return result;
    }
    public int countGoodNumbers(long n) {
        int result = 0;
        int i =0 ;
        String number = Long.toString(n);
        int len = number.length();
        
        return count(number,result, len , 0);
    }
}*/
class Solution {
    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Calculate how many even positions and odd positions we have
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;

        // Total combinations = (5^even) * (4^odd) % MOD
        long firstPart = power(5, evenIndices);
        long secondPart = power(4, oddIndices);

        return (int) ((firstPart * secondPart) % MOD);
    }

    // Fast modular exponentiation helper method: (base^exp) % MOD
    private long power(long base, long exp) {
        if (exp == 0) return 1;
        
        long half = power(base, exp / 2);
        long halfSquared = (half * half) % MOD;

        // If exponent is odd, multiply by base one more time
        if (exp % 2 != 0) {
            return (halfSquared * base) % MOD;
        }

        return halfSquared;
    }
}
