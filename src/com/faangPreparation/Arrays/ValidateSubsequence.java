package com.faangPreparation.Arrays;
/*
validate if a subsequence is present in array or not

[5,1,22,25,6,-1,8,10]
[1,6,-1,10]

output: True
 */

public class ValidateSubsequence {
    private static boolean isSubsequencePresent(int[] arr, int[] subs){
        int i=0;
        int j=0;
        int count = 0;
        while(i<subs.length && j<arr.length){
            if(arr[j] == subs[i]){
                j=j+1;
                i=i+1;
                count = count + 1;
            }else{
                j=j+1;
            }
        }
        return count == subs.length;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,22,25,6,8,10,-1,10};
        int[] subs = {1,6,-1,10};
        System.out.println(isSubsequencePresent(arr, subs));
    }
}
