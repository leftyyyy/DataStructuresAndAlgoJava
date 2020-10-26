package com.faangPreparation.Arrays;
/*
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

    -> A.length >= 3
    -> There exists some i with 0 < i < A.length - 1 such that:
            *-> A[0] < A[1] < ... A[i-1] < A[i]
            *-> A[i] > A[i+1] > ... > A[A.length - 1]

     eg:
        0,2,3,4,5,2,1,0 -> valid mountain array
        because, 0,2,3,4,5 - strictly increasing
                 5,2,1,0   - strictly decreasing

        0,2,3,3,5,2,1,0 -> not valid mountain array
        because, 0,2,3,3 -> not strictly decreasing

Example 1:
    Input: [2,1]
    Output: false

Example 2:
    Input: [3,5,5]
    Output: false

Example 3:
    Input: [0,3,2,1]
    Output: true

Note:
    -> 0 <= A.length <= 10000
    -> 0 <= A[i] <= 10000
 */
public class ValidMountainArray {
    private static boolean solution(int[] A){
        if(A.length<3){
            return false;
        }else{
            int i=0;
            int j=0;
            while(i<A.length-1){
                if(A[i]<A[i+1]){
                    i=i+1;
                }else if(A[i]==A[i+1]){
                    return false;
                }else{
                    j = i+1;
                    break;
                }
            }
            if(i==A.length-1 || i==0){
                return false;
            }
            while(j<A.length){
                if(A[j]<A[i]){
                    j=j+1;
                    i=i+1;
                }else if(A[j]==A[i]){
                    return false;
                }else{
                    return false;
                }
            }
            if(j>=A.length-1){
                return true;
            }else{
                return false;
            }
        }
    }
}
