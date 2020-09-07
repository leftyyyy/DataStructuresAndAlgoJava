package com.leftyyyy.dynamicProgramming;

import java.util.Scanner;

public class EditDistance {
    public static int editDistance(char[] s, char[] t) {
        int [][] array = new int[t.length+1][s.length+1];
        for(int i=0;i<=t.length;i++){
            if(i==0){
                for(int j=0;j<=s.length;j++){
                    array[i][j]=j;
                }
            }else{
                array[i][0]=i;
            }
        }
        for(int i=1;i<=t.length;i++){
            for(int j=1;j<=s.length;j++){
                if(s[j-1]==t[i-1]){
                    array[i][j]=array[i-1][j-1];
                }else{
                    int tmp = Math.min(array[i][j-1], array[i-1][j-1]);
                    int min = Math.min(tmp, array[i-1][j]);
                    array[i][j]=min+1;
                }
            }
        }
        return array[t.length][s.length];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        char[] ch_s = s.toCharArray();
        char[] ch_t = t.toCharArray();
        System.out.println(editDistance(ch_s, ch_t));
    }
}
