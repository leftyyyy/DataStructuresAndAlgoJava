package com.faangPreparation;
/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].
An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.



Example 1:
    Input: [1,2,2,3]
    Output: true

Example 2:
    Input: [6,5,4,4]
    Output: true

Example 3:
    Input: [1,3,2]
    Output: false

Example 4:
    Input: [1,2,4,5]
    Output: true

Example 5:
    Input: [1,1,1]
    Output: true


Note:
    1 <= A.length <= 50000
    -100000 <= A[i] <= 100000
 */
public class MonotonicArray {
    private static boolean isMonotonic(int[] A){
        if(A.length<3){
            return true;
        }
        int dir = -2;
        int i=0;
        while(i!=A.length-1){
            if(A[i]==A[i+1]){
                i=i+1;
                continue;
            }else{
                break;
            }
        }
        if(i==A.length-1){
            return true;
        }else{
            if(A[i]<A[i+1]){
                dir = 1;
                i=i+1;
            }else{
                dir = -1;
                i=i+1;
            }
        }
        int checker = dir;
        while(i<A.length-1){
            if(checker==dir){
                if(A[i]<A[i+1]){
                    dir = 1;
                }else if(A[i]>A[i+1]){
                    dir = -1;
                }
            }else{
                return false;
            }
            i=i+1;
        }
        if(checker==dir){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,1,2,3,4,4,5,4};
        boolean output = isMonotonic(input);
        System.out.println(output);
    }
}
