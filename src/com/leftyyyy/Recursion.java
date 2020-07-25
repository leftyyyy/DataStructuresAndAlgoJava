package com.leftyyyy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Recursion {
    //Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to print the answer.
    //Note : For this question, you can assume that 0 raised to the power of 0 is 1
    //Input format :
    //Two integers x and n (separated by space)
    //Output Format :
    //x^n (i.e. x raise to the power n)
    //Constraints:
    //        0 <= x <= 8
    //        0 <= n <= 9
    //Sample Input 1 :
    //        3 4
    //Sample Output 1 :
    //        81
    //Sample Input 2 :
    //        2 5
    //Sample Output 2 :
    //        32
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int smallOutput = power(x,n-1);
        int output = x*smallOutput;
        return output;
    }

    public static void driverPower(){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        int res = power(x, n);
        System.out.println(res);

    }

    //Given an array of length N, you need to find and return the sum of all elements of the array.
    //Do this recursively.
    //Input Format :
    //Line 1 : An Integer N i.e. size of array
    //Line 2 : N integers which are elements of the array, separated by spaces
    //Output Format :
    //Sum
    //Constraints :
    //        1 <= N <= 10^3
    //Sample Input 1 :
    //        3
    //        9 8 9
    //Sample Output 1 :
    //        26
    //Sample Input 2 :
    //        3
    //        4 2 1
    //Sample Output 2 :
    //        7

    public static Integer sumArr(ArrayList arr, int startIndex){
        if(arr.size()==startIndex){
            return 0;
        }
        return (Integer) arr.get(startIndex) + sumArr(arr, startIndex+1);
    }
    public static void driverSumArr(){
        String input = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            input = br.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();

        String[] tmp_array = input.split("\\s");
        for(String x: tmp_array){
            arr.add(Integer.valueOf(x));
        }

        System.out.println(sumArr(arr, 0));

    }

}
