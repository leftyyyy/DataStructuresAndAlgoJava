package com.leftyyyy.dynamicProgramming;
import java.util.Scanner;

public class DPchange {
    private static int getChange(int m) {
        int[][] arr = new int[4][m+1];
        int[] coins = new int[]{ 1,3,4 };
        for(int i=0;i<4;i++){
            if(i==0){
                for(int j=0;j<=m;j++){
                    arr[i][j] = j;
                }
            }else{
                arr[i][0] = 0;
            }
        }
        for(int i=1;i<=3;i++){
            for(int j=1;j<=m;j++){
                if(j>=coins[i-1]){
                    arr[i][j] = Math.min(arr[i-1][j], 1+arr[i][j-coins[i-1]]);
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return arr[3][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
