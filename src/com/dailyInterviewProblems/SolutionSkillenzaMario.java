package com.dailyInterviewProblems;

import java.util.Scanner;

public class SolutionSkillenzaMario {
    private static int IncreasingLength(int[] arr, int n){
        int max = 1, len = 1;
        for (int i=1; i<n; i++){
            if (arr[i] >= arr[i-1]){
                len++;
            }else{
                if (max < len){
                    max = len;
                }
                len = 1;
            }
        }
        if (max < len){
            max = len;
        }
        return max;
    }
    private static int DecreasingLength(int[] arr, int n){
        int max = 1, len = 1;
        for (int i=1; i<n; i++){
            if (arr[i-1] >= arr[i]){
                len++;
            }else{
                if (max < len){
                    max = len;
                }
                len = 1;
            }
        }
        if (max < len){
            max = len;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int[] input = new int[n];
            for(int j=0;j<n;j++){
                input[j] = sc.nextInt();
            }
            int iL = IncreasingLength(input, n);
            int dL = DecreasingLength(input, n);
            if(iL>=dL){
                res[i] = iL;
            }else{
                res[i] = dL;
            }
        }
        for(int i=0;i<t;i++){
            System.out.println(res[i]);
        }
    }
}
