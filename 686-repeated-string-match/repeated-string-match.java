class Solution {
    private boolean rabinKarp(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        if(m > n) return false;

        long base = 256; // 256 ascii char
        long mod = 1000000007; // largest prime no 

        long patternhash =0;
        long texthash =0;
        long power =1;
        //calculate base ^(m-1)
        for(int i =0 ; i< m-1;i++){
            power = (power *base)% mod;
        }

        //compute initial hash values
        for(int i =0 ; i< m ;i++){
            patternhash =( patternhash*base +pattern.charAt(i)) %mod;
            texthash =( texthash*base + text.charAt(i)) %mod;
        }
        //slide th windows
        for(int i =0 ; i<= n-m ;i++){
            //if hashes match , verify char
            if(patternhash == texthash){
                if(text.substring(i,i+m).equals(pattern)){
                    return true;
                }
            }

            //compute hash for next window
            if(i<n-m){
                texthash = (texthash - text.charAt(i) * power) %mod;
                if(texthash <0 ){
                    texthash += mod;
                }
                texthash = (texthash *base + text.charAt(i+m))%mod;
            }
        }
        return false;
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count =1;

        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        } 
        if(rabinKarp(sb.toString(),b)){
            return count;
        }

        sb.append(a);
        if(rabinKarp(sb.toString(),b)){
            return count+1;
        }
        return -1;
    }
}