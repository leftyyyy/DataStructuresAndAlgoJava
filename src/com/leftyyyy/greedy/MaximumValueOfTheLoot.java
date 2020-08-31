package com.leftyyyy.greedy;

import java.util.*;

public class MaximumValueOfTheLoot {
    private static double getOptimalValue(double capacity, int[] values, int[] weights, int n) {
        double value = 0;
        Map<Double, ArrayList> valueperunitmap = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            ArrayList<Double> arrL = new ArrayList<>();
            arrL.add((double)values[i]);
            arrL.add((double)weights[i]);
            double tmp = ((double)values[i])/((double)weights[i]);
            valueperunitmap.put(tmp, arrL);
        }
        for (Map.Entry mapElement : valueperunitmap.entrySet()) {
            double key = (double)mapElement.getKey();
            ArrayList val = (ArrayList) mapElement.getValue();
            if(capacity>=(double)val.get(1)){
                capacity = capacity - (double)val.get(1);
                value = value + key*(double)val.get(1);
            }else{
                value = value + key*capacity;
                capacity = 0;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue((double)capacity, values, weights, n));
    }
}

/*
import java.util.Scanner;

public class MaximumValueOfTheLoot {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] unitValue = new double[values.length];
        for(int i = 0; i < values.length; i++) {
            unitValue[i] = (double)values[i]/(double)weights[i];
        }
        //Sorting
        for(int i = 0; i < unitValue.length-1; i++) {
            for(int j = 0; j < unitValue.length-i-1; j++) {
                if(unitValue[j] < unitValue[j+1]) {
                    double temp = unitValue[j];
                    unitValue[j] = unitValue[j+1];
                    unitValue[j+1] = temp;
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = (int)temp;
                    temp = weights[j];
                    weights[j] = weights[j+1];
                    weights[j+1] = (int)temp;
                }
            }
        }
        int i = 0;
        int temp = 0;
        while(temp <= capacity && i < weights.length) {
            if(weights[i] <= (capacity-temp)){
                temp += weights[i];
                value += values[i];
            } else {
                value += unitValue[i]*(capacity-temp);
                break;
            }
            i++;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
*/
