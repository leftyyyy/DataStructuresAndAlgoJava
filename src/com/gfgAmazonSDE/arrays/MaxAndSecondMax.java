package com.gfgAmazonSDE.arrays;

import javafx.util.Pair;

/*
Max and Second Max

Given an array arr[] of size N of positive integers which may have duplicates.
The task is to find the maximum and second maximum from the array, and both of them should be distinct,
so If no second max exists, then the second max will be -1.

Input Format:
The first line of input contains the number of test cases T.
For each test case, the first line of input contains the size of array N, the next line contains array elements.

Output Format:
For each test case, print the maximum and second maximum from the array.
IF no second max exists, print "-1" for the second max.

User Task:
The task is to complete the function largestAndSecondLargest(),
which should return maximum and second maximum element from the array with first element as maximum element
and second element as second maximum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 10^6
1 <= arr[i] <= 10^6

Example:
Input:
3
5
1 2 3 4 5
3
2 1 2
2
5 5

Output:
5 4
2 1
5 -1

Explanation:
Testcase 1: From the given array elements, 5 is the largest and 4 is the second largest.
Testcase 2: From the given array elements, 2 is the largest and 1 is the second largest.
Testcase 3: From the given array elements, 5 is the largest and -1 is the second largest.
 */
public class MaxAndSecondMax {
    private static Pair<Integer, Integer> largestAndSecondLargest(int[] arr){
        Pair<Integer, Integer> p = new Pair<>(-1, -2);
        int largest = p.getKey();
        int secondLargest = p.getValue();

        return p;
    }
}
