package com.seena.practise.ds.queue_stack;

public class PerfectSquare {
    static int[] dp  = new int[13];

    public static void main(String[] args){
        System.out.println(" Min Perfect squares "+ minPerfectSquares(13));
    }

    private static int minPerfectSquares(int num) {
        int ans = solve(num);
        return ans;
    }

    private static int solve(int num) {
        if(num<=3){
            return num;
        }
        /*
        Memorisation to check, if already computed and memorised then it will be taken
         */
        if(dp[num-1] != 0){
            return dp[num-1];
        }
        int ans = num;
        for(int i =1; i*i <=num;i++){
            ans = Math.min(ans, 1+solve(num-i*i));
        }
        //memorising for the future reference
        dp[num-1] = ans;
        return ans;
    }
}
