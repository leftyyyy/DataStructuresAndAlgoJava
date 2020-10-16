package com.faangPreparation.dynamicProgramming;
/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

Example 2:
    Input: coins = [2], amount = 3
    Output: -1

Example 3:
    Input: coins = [1], amount = 0
    Output: 0

Example 4:
    Input: coins = [1], amount = 1
    Output: 1

Example 5:
    Input: coins = [1], amount = 2
    Output: 2

Constraints:

    *-> 1 <= coins.length <= 12
    *-> 1 <= coins[i] <= 2**31 - 1
    *-> 0 <= amount <= 10**4
 */
import java.util.Arrays;

public class MinimumNumberCoinsForChange {
    public static int coinChange(int[] coins, int amount) {
        int i=0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10004);
        dp[0] = 0;
        while(i<coins.length){
            int j=coins[i];
            while(j<amount+1){
                if(coins[i]<=amount){
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]);
                }
                j=j+1;
            }
            i=i+1;
        }
        if(dp[amount]!=10004){
            return dp[amount];
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,2,5};
        System.out.println(coinChange(input, 11));
    }
}
