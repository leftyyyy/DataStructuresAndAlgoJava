package com.faangPreparation.Arrays;
/*
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
    -> B.length >= 3
    -> There exists some 0 < i < B.length - 1 such that
            B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]

(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:
    Input: [2,1,4,7,3,2,5]
    Output: 5
    Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

Example 2:
    Input: [2,2,2]
    Output: 0
    Explanation: There is no mountain.

Note:
    1. 0 <= A.length <= 10000
    2. 0 <= A[i] <= 10000

Follow up:
    *-> Can you solve it using only one pass?
    *-> Can you solve it in O(1) space?
 */
public class LongestMountainInArray {
    //singlePass solution
    private static int longestPeak(int[] A){
        if(A.length<3){
            return 0;
        }
        int i=0;
        int j=i;
        int k=j;
        int length = 0;
        while(i<A.length-1){
            if(A[i]<A[i+1]){
                j=i+1;
                k=j;
                while(j<A.length-1){
                    if(A[j]<A[j+1]){
                        j=j+1;
                        k=j;
                    }else if(A[j]==A[j+1]){
                        j=j+1;
                        i=j;
                        k=j;
                        break;
                    }else{
                        k=k+1;
                        break;
                    }
                }
                if(j==A.length-1){
                    break;
                }
                if(i==j && i==k){
                    continue;
                }
                while(k<A.length-1){
                    if(A[k]>A[k+1]){
                        k=k+1;
                    }else{
                        break;
                    }
                }
                if(k-i+1>length){
                    System.out.println(i+" "+k);
                    length = k - i + 1;
                }
                i=k;
                j=i;
                k=j;
            }else{
                i=i+1;
                j=i;
                k=j;
            }
        }
        return length;
    }

    //leetCode most voted solution
    private static int longestPeakSolution2(int[] A){
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }

    //algoExpertWay
    private static int longestPeakSolutionAlgoExp(int[] A){
        return 0;
    }

    public static void main(String[] args) {
        int[] input = {0,2,0,0,2,0,2,1,1,0,2,1,0,0,1,0,2,1,2,0,1,1,0,2,2,1,2,2,0,0,0,1,0,2,0,0,1,2,0,1,0,2,0,2,0,0,0,0,2,1,0,0,0,0,1,0,2,1,2,2,1,0,0,1,0,2,0,0,0,2,1,0,1,2,1,0,1,0,2,1,0,2,0,2,1,1,2,0,1,0,1,1,1,1,2,1,2,2,2,0};
        int output = longestPeak(input);
        System.out.println(output);
    }
}
