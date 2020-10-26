package com.gfgAmazonSDE.arrays;
/*
Third largest element
Given an array of distinct elements. Find the third largest element in it.

Input:
The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. The first line of each test case is N, size of the array.
The second line of each test case contains N space separated values of the array a[].

Output:
Print the third largest element of the array. If the array has less than 3 elements print -1.

Your Task:
Complete the function thirdLargest() which takes the array a[] and the size of the array, n,
as input parameters and returns the third largest element in the array.
It return -1 if there are less than 3 elements in the given array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^5

Example:
Sample Input:
2
5
2 4 1 3 5
2
10 2

Sample Output:
3
-1

Explanation:
Test Case 1: Largest number is 5, followed by 4 and then 3. Hence, the answer is 3.
Test Case 2: Since there are less than 3 numbers, output is -1.
 */

import java.util.Scanner;

public class ThirdLargestElement {
    //array is of distinct elements
    //but this still works if it has duplicates element
    //but it doesn't ignore duplicates
    private static int getElement(int[] arr, int n){
        int max = -999999999;
        int secMax = -999999999;
        int thirdMax = -999999999;
        for(int i=0; i<n; i++){
            if(arr[i]>=max){
                thirdMax = secMax;
                secMax = max;
                max = arr[i];
            }else if(arr[i]>=secMax){
                thirdMax = secMax;
                secMax = arr[i];
            }else if(arr[i]>=thirdMax){
                thirdMax = arr[i];
            }
        }
        return thirdMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            res[i] = getElement(arr, n);
        }
        for(int i=0;i<t;i++){
            System.out.println(res[i]);
        }
    }
}
//12, 13, 1, 10, 34, 16 ---> 13
//10, 5, 15, 5, 15, 10, 1, 1 ---> 10 (should be 5 if we ignore duplicates)
//1, 14, 2, 16, 10, 20 ---> 14
//19, -10, 20, 14, 2, 16, 10 ---> 16