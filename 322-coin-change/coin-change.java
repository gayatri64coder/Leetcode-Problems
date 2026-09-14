class Solution {
    private int f(int ind , int T , int[] nums , int [][] dp){
        if(ind == 0){
            if(T % nums[0] == 0 ) return T/nums[0];
            return (int) 1e9;

        }
        if( dp[ind][T] != -1) return dp[ind][T];
        int nottake = 0+ f(ind-1, T, nums, dp);
        int take = Integer.MAX_VALUE;

        if(nums[ind] <= T){
            take = 1+ f(ind, T-nums[ind], nums, dp);
        }
        return dp[ind][T] = Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        /*if(coins.length == 1 && amount > coins[0]){
            return -1;
        }
        if( amount == 0){
            return 0;
        }
        int count =0 ;
        for(int i = coins.length -1; i >=0  ;i--){
            if( (amount /coins[i]) != 0 ){
                count += amount /coins[i];
                amount = amount - count * coins[i];
            }

        }*/

        int n = coins.length;
        int [][] dp = new int[n][amount+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = f(n-1, amount, coins, dp);
        if(ans >= 1e9) return -1;
        return ans;
    }
}