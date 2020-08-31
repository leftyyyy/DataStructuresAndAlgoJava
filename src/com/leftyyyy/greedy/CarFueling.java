package com.leftyyyy.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class CarFueling {
    public static int computeMinRefills(int dist, int tank, int[] stops) {
        int count = 0;
        ArrayList<Integer> stopsList = new ArrayList<>();
        for(int t:stops) {
            stopsList.add(t);
        }
        ArrayList<Integer> stopsLists =  (ArrayList<Integer>) stopsList.clone();
        for (int item:stopsLists) {
            if(item>=tank && item<=dist){
                if(item==tank){
                    int i = 0;
                    while(stopsList.get(i)!=item){
                        stopsList.remove(i);
                    }
                    count = count + 1;
                    tank = tank + item;
                }else{
                    int i=0;
                    while(i<stopsList.indexOf(item)-1){
                        stopsList.remove(i);
                    }
                    count = count + 1;
                    tank = tank + stopsList.get(stopsList.indexOf(item)-1);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n+2];
        stops[0]=0;
        for (int i = 1; i < n+1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n+1] = dist;
        /*
        for (int item:stops) {
            System.out.print(item+" ");
        }
        System.out.println();
         */
        if(n==1){
            System.out.println(1);
        }else{
            System.out.println(computeMinRefills(dist, tank, stops));
        }
    }
}
