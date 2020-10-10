package com.faangPreparation;
/*
Given an array nums, and a integer
write a function to move all given integers's to the end of it
while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12], 0
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MovingElementToEnd {
    //when order doesn't matter
    private static int[] moveToEndNotMaintainingOrder(int[] arr, int element){
        return arr;
    }

    //when order matters
    //100% fast
    private static int[] moveToEndMaintainingOrder(int[] arr, int element){
        if(arr.length<2){
            return arr;
        }
        if(arr.length == 2){
            if(arr[0] == element){
                int tmp = arr[1];
                arr[1] = arr[0];
                arr[0] = tmp;
            }
            return arr;
        }
        int i= 0;
        int j= -1;
        while(i<arr.length){
            if(arr[i]!=element){
                int tmp = arr[i];
                arr[i] = arr[j+1];
                arr[j+1] = tmp;
                j=j+1;
            }
            i=i+1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        int element = 0;
        int[] res = moveToEndMaintainingOrder(input, element);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}
