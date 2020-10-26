package com.codeforcesPractice.points800;

import java.util.Scanner;

/*
1,11,111,1111
2,22,222,2222,
3,33,333,3333,
4,44,444,4444,
5,55,555,5555,
6,66,666,6666,
7,77,777,7777,
8,88,888,8888,
9,99,999,9999
 */
public class BoringApartments {
    private static int sol(int inp){
        String[] arr = {"1","11","111","1111","2","22","222","2222","3","33","333","3333","4","44","444","4444","5","55","555","5555","6","66","666","6666","7","77","777","7777","8","88","888","8888","9","99","999","9999"};
        int i=0;
        int count=0;
        while(i<arr.length){
            if(Integer.parseInt(arr[i])==inp){
                count = count + arr[i].length();
                break;
            }else{
                count = count + arr[i].length();
                i=i+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];
        for(int i=0; i<t; i++){
            int inp = sc.nextInt();
            res[i] = sol(inp);
        }
        for(int i=0; i<t; i++){
            System.out.println(res[i]);
        }
    }
}
