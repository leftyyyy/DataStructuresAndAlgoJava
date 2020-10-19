package com.faangPreparation.dynamicProgramming;
/*
Given two words word1 and word2,
find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')

Example 2:
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
        intention -> inention (remove 't')
        inention -> enention (replace 'i' with 'e')
        enention -> exention (replace 'n' with 'x')
        exention -> exection (replace 'n' with 'c')
        exection -> execution (insert 'u')
 */
public class EditDistance {
    //time complexity: O(NM)
    //Space complexity: O(NM)
    private static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int filler = 0;
        while(filler<word1.length()+1 || filler<word2.length()+1){
            if(filler<word2.length()+1){
                dp[0][filler] = filler;
            }
            if(filler<word1.length()+1){
                dp[filler][0] = filler;
            }
            filler = filler + 1;
        }
        int i=0;
        while(i<word1.length()){
            int j=0;
            while(j<word2.length()){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) + 1;
                }
                j=j+1;
            }
            i=i+1;
        }
        return dp[word1.length()][word2.length()];
    }


    //time complexity- O(NM)
    //Space complexity - O(rows*2) -- because at any time we're using only current row and previous row
    private static int minDistanceImproved(String word1, String word2){
        int[] preFilled = new int[word2.length()+1];
        for(int i=0; i<word2.length()+1; i++){
            preFilled[i] = i;
        }
        int i=0;
        while(i<word1.length()){
            int j=0;
            int[] dp = new int[word2.length()+1];
            dp[0] = i+1;
            while(j<word2.length()){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[j+1] = preFilled[j];
                }else{
                    dp[j+1] = Math.min(preFilled[j], Math.min(preFilled[j+1], dp[j])) + 1;
                }
                j=j+1;
            }
            preFilled = dp;
            i=i+1;
        }
        return preFilled[word2.length()];
    }

    //needs debugging
    private static int minDistanceImprovedAlgoExpertWay(String word1, String word2){
        String small = "";
        String big = "";
        if(word1.length()<word2.length()){
            small = word1;
            big = word2;
        }else{
            small = word2;
            big = word1;
        }
        int[] evenEdits = new int[small.length()+1];
        int[] oddEdits = new int[small.length()+1];
        for(int i=0; i<small.length()+1; i++){
            evenEdits[i] = i;
            oddEdits[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<big.length()+1; i++){
            int[] currentEdits;
            int[] previousEdits;
            if(i%2==1){
                currentEdits = oddEdits;
                previousEdits = evenEdits;
            }else{
                currentEdits = evenEdits;
                previousEdits = oddEdits;
            }
            currentEdits[0] = i;
            for(int j=1; j<small.length()+1; j++){
                if(big.charAt(i-1)==small.charAt(j-1)){
                    currentEdits[j] = previousEdits[j-1];
                }else{
                    currentEdits[j] = Math.min(previousEdits[j-1], Math.min(previousEdits[j], currentEdits[j-1]));
                }
            }
        }
        if(big.length()%2==0){
            return evenEdits[small.length()];
        }else{
            return oddEdits[small.length()];
        }
    }


    //leetCodeBestSolution
    public int minDistanceLeetCodeSolutionBest(String word1, String word2){
        // corner case
        if (word1 == null || word1.length() == 0) {
            if (word2 == null || word2.length() == 0) return 0;
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            if (word1 == null || word1.length() == 0) return 0;
            return word1.length();
        }
        int[][] mem = new int[word1.length()][word2.length()];

        return dfs(word1, word1.length(), word2, word2.length(), mem);
    }
    private int dfs (String word1, int idx1, String word2, int idx2, int[][]mem){
        if (idx1 == 0) return idx2;
        if (idx2 == 0) return idx1;
        if (mem[idx1 - 1][idx2 - 1] > 0) return mem[idx1 - 1][idx2 - 1]; // 读值

        char c1 = word1.charAt(idx1 - 1), c2 = word2.charAt(idx2 - 1);
        int res;
        if (c1 == c2) {
            res = dfs(word1, idx1 - 1, word2, idx2 - 1, mem);
        } else {
            int val1 = dfs(word1, idx1, word2, idx2 - 1, mem);
            int val2 = dfs(word1, idx1 - 1, word2, idx2, mem);
            int val3 = dfs(word1, idx1 - 1, word2, idx2 - 1, mem);
            res = Math.min(Math.min(val1, val2), val3) + 1;
        }
        mem[idx1 - 1][idx2 - 1] = res; // 存值
        return mem[idx1 - 1][idx2 - 1];
    }


    //mainMethod
    public static void main(String[] args) {
        System.out.println(minDistanceImprovedAlgoExpertWay("intention", "execution"));
    }
}
