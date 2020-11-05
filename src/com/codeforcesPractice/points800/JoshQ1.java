package com.codeforcesPractice.points800;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class JoshQ1 {
    static int getLongestSubArrayLength(List<Integer> elements){
        //using two pointers at the begining of array
        int i=0;
        int j=0;

        while(j<elements.size()-1){
            //if first element is even
            if(elements.get(j)%2==0){
                //if next element is odd
                if(elements.get(j+1)%2!=0){
                    //then pointer i will be at first element
                    //pointer j will move on to next element
                    //and we will check that element
                    j=j+1;
                }
                //if next element is even
                else{
                    //increment both pointers to next element
                    i=i+1;
                    j=i;
                }
            }
            //if first element is odd
            else{
                //if next element is even
                if(elements.get(j+1)%2==0){
                    //then pointer i will be at first element
                    //pointer j will move on to next element
                    //and we will check that element
                    j=j+1;
                }
                //if next element is odd
                else{
                    //then pointer i will be at first element
                    //pointer j will move on to next element
                    //and we will check that element
                    i=i+1;
                    j=i;
                }
            }
        }
        //return difference between pointers increment by 1
        return Math.abs(j-i)+1;
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        List<Integer> elements = new ArrayList<>(length);

        for(int i=0; i<length; ++i){
            elements.add(scanner.nextInt());
        }

        System.out.println(getLongestSubArrayLength(elements));
    }
}
