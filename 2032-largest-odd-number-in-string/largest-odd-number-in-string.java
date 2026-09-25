
class Solution {
    public String largestOddNumber(String num) {
        /*BigInteger number = new BigInteger(num);
        BigInteger maximum =0;
        if(number.mod(2).equals(0)){
            while( ! number.equals(0)){
                BigInteger last = number.mod(10);
                number = number.divide(10);
                if((number.mod(2)).equals(0) ){
                    maximum = Math.max(maximum, number);
                    return BigInteger.toString(maximum);
                }
            }
            return "";
            
        }
        return BigInteger.toString(number);*/

        for(int i = num.length()-1 ; i>= 0 ; i--){
            char c = num.charAt(i);

            if( c == '1' ||c == '3' || c == '5'|| c == '7' || c == '9'){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}