package com.leftyyyy.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Example {
    static Iterator fun(ArrayList myList){
        Iterator it = myList.iterator();
        while(it.hasNext()){
            Object element = it.next();
            if(element instanceof String){
                break;
            }
        }
        return it;
    }
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();

    }
}
