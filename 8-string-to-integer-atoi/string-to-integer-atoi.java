class Solution {
    private int stringtointeger(String s , int sign , int i, long result){
        //base case
        if(i >= s.length()){
            return (int) (result*sign);
        }
        char ch = s.charAt(i);
        if(ch < '0' || ch > '9'){
            return (int) (result*sign);
        }
        result = result * 10 +(ch -'0');
        if (result > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return stringtointeger(s,sign, i+1 , result);
        
    
    }
    public int myAtoi(String s) {
        s = s.trim();//remove leading zeros
        if(s.length() == 0){
            return 0;
        }
         
        int sign = 1;
        int i = 0;
        long result =0 ;
        if(s.charAt(0) == '-' ){
            sign = -1;
            i++;
        }else if (s.charAt(0) == '+'){
            i++;
        }
        result =  stringtointeger(s,sign ,i , result);
        return (int) result;
    }
}

