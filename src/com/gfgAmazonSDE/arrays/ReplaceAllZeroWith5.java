package com.gfgAmazonSDE.arrays;
/*
You are given an integer N. You need to convert all zeroes of N to 5.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single integer N denoting the number.

Output:
For each test case, there will be a new line containing an integer where all zero's are converted to 5.

Your Task:
Your task is to complete the function convertFive() which takes an integer N as an argument and replaces all zeros in the number N with 5. Your function should return the converted number.

Expected Time Complexity: O(K) where K is the number of digits in N
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
1 <= n <= 10000

Example:
Sample Input:
2
1004
121

Sample Output:
1554
121

Explanation:
Test Case 1: There are two zeroes in "1004", on replacing all zeroes with "5", the new number will be "1554".
Test Case 2: Since there are no zeroes in "121", the number remains as "121".
 */

import java.util.Scanner;

public class ReplaceAllZeroWith5 {
    private static int convert(int n){
        int k = 0;
        int res = n;
        while(n/((int) Math.pow(10,k))!=0){
            int tmp = (n/((int) Math.pow(10,k)))%10;
            if(tmp==0){
                res = res + 5*((int) Math.pow(10, k));
            }
            k=k+1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(convert(n));
    }
}
