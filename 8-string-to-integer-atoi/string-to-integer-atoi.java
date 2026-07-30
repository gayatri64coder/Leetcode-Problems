class Solution {
    public int myAtoi(String s) {
        
        s = s.trim(); // handeled white spaces 
        long result =0;
        int i = 0 ;
        int sign = 1;
        if( s.length() == 0){ // base case if string is empty
            return 0;
        }

        //signed integer
        if(s.charAt(0) =='-' ){
            sign = -1;
            i++;
        }else if(s.charAt(0) =='+' ){
            i++;
        }

        while(i < s.length()){
            char ch = s.charAt(i);
            //nonnumeric char handled
            if(ch < '0' || ch > '9'  ){
                break;
            }
            result = result * 10 + (ch -'0');
            //integer overflow
            if(sign * result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign * result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
            
        }
        return (int)(sign * result);
    }
}

