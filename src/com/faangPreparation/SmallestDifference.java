package com.faangPreparation;

import java.util.Arrays;

/*
Find smallest difference between two array's elements
[-1,5,10,20,28,3] [26,134,135,15,17]

output: [28,26]

28 - 26 = 2 -- minimum difference
 */
public class SmallestDifference {
    private static int[] findElementsWithMinimumDifference(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] res = new int[2];
        int i=0;
        int j=0;
        int diff = Math.abs(arr1[0] - arr2[0]);
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]-arr2[j]==0) {
                res[0] = arr1[i];
                res[1] = arr2[j];
                break;
            }else if(arr1[i]<arr2[j]){
                if(diff>=Math.abs(arr1[i]-arr2[j])){
                    diff = Math.abs(arr1[i]-arr2[j]);
                    res[0] = arr1[i];
                    res[1] = arr2[j];
                }
                i=i+1;
            }else{
                if(diff>=Math.abs(arr1[i]-arr2[j])){
                    diff = Math.abs(arr1[i]-arr2[j]);
                    res[0] = arr1[i];
                    res[1] = arr2[j];
                }
                j=j+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1,5,10,20,28,3};
        int[] arr2 = {26,134,135,15,17};
        int[] out = findElementsWithMinimumDifference(arr1, arr2);
        for(int i=0; i<2; i++){
            System.out.println(out[i]);
        }
    }
}
