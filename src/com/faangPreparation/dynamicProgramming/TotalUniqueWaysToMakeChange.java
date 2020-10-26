package com.faangPreparation.dynamicProgramming;
/*
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.



Example 1:
    Input: amount = 5, coins = [1, 2, 5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

Example 2:
    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
    Input: amount = 10, coins = [10]
    Output: 1

Note:
    You can assume that
        *-> 0 <= amount <= 5000
        *-> 1 <= coin <= 5000
        *-> the number of coins is less than 500
        *-> the answer is guaranteed to fit into signed 32-bit integer
 */
public class TotalUniqueWaysToMakeChange {
    private static int change(int amount, int[] coins){
        int i=0;
        int[] ways = new int[amount+1];
        ways[0]=1;
        while(i<coins.length){
            if(coins[i]>amount){
                i=i+1;
                continue;
            }else{
                int j = coins[i];
                while(j<ways.length){
                    //ways[targetAmount]=ways[targetAmount]+ways[targetAmount - coinDenomination]
                    ways[j] = ways[j] + ways[j-coins[i]];
                    j=j+1;
                }
            }
            i=i+1;
        }
        return ways[amount];
    }

    public static void main(String[] args) {
        int[] input = {1,2,5};
        System.out.println(change(5,input));
    }
}
