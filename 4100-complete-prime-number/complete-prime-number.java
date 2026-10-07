class Solution {
    public boolean completePrime(int num) {
        if( num <= 0 ){
            return false ;
        }
        /*if(!isPrime(num)){
            return false;
        }
        while(num != 0){
            int lastnum = num % 10;
            if(!isPrime(lastnum)){
                return false;
            }
            num = num/10;
        }
        return true; */

        String s = String.valueOf(num);
        int n = s.length();

        for(int i =1; i< n ; i++){
            int prefix = Integer.parseInt(s.substring(0,i));
            if(!isPrime(prefix)){
                return false;
            }
        }

        for(int i =0 ; i< n ; i++){
            int suffix = Integer.parseInt(s.substring(i));
            if(!isPrime(suffix)){
                return false;
            }
        }
        return true;
    }
    private boolean isPrime(int num ){
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num) ;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}