package com.leftyyyy.greedy;

import java.util.Scanner;

public class MoneyChange {
    public static int getNumberCoins(int amount){
        int m =  amount;
        int count = 0;
        while(m!=0){
            if(m>=10){
                count = count + m/10;
                m = m % 10;
            }else if(m>=5 && m<10){
                count = count + m/5;
                m = m % 5;
            }else{
                m = m - 1;
                count = count + 1;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int amount;
        Scanner sc = new Scanner(System.in);
        amount = sc.nextInt();
        System.out.println(getNumberCoins(amount));
    }
}

//another approach
/*
import java.util.Scanner;
public class MoneyChange {
    public static int getNumberCoins(int amount){
        int m =  amount;
        int count = 0;
        while(m!=0){
            if(m>=10){
                m = m - 10;
                count = count + 1;
            }else if(m>=5 && m<10){
                m = m - 5;
                count = count + 1;
            }else{
                m = m - 1;
                count = count + 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int amount;
        Scanner sc = new Scanner(System.in);
        amount = sc.nextInt();
        System.out.println(getNumberCoins(amount));
    }
}
*/
