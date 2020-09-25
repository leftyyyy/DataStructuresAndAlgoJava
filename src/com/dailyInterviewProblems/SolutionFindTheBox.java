package com.dailyInterviewProblems;

import java.util.Scanner;

public class SolutionFindTheBox {
    private static int binarySearch(int[] a, int x) {
        if(x==0 || x>a[a.length-1]){
            return -1;
        }
        int left = 0, right = a.length - 1;
        while(left<=right){
            int mid = left + ((right - left)/2);
            if(x==a[mid]){
                return mid;
            }else if(x<a[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left<a.length){
            return left;
        }else{
            return -1;
        }
    }

    private static int[] generateArray(int[] arr, int n){
        int[] resArr = new int[n];
        resArr[0] = arr[0];
        for(int i=1; i<n; i++){
            resArr[i] = resArr[i-1] + arr[i];
        }
        return resArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] arrayToWorkWith = generateArray(arr, n);

        int querySize = sc.nextInt();
        int[] queries = new int[querySize];
        for(int i=0; i<querySize; i++){
            queries[i] = sc.nextInt();
        }

        for(int i=0; i<querySize; i++){
            System.out.println(binarySearch(arrayToWorkWith, queries[i])+1);
        }

    }
}
