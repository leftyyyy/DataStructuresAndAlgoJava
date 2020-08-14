package com.leftyyyy.stacks;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Character> arr;
    private int top;
    Stack(){
        arr = new ArrayList<Character>();
        top = -1;
    }

    public ArrayList getStack(){
        return arr;
    }
    public Character getTop(){
        if(top==-1){
            return null;
        }
        return arr.get(top);
    }

    public Boolean isEmpty(){
        if(top==-1){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void push(char data){
        arr.add(data);
        top=top+1;
    }

    public char pop(){
        return arr.remove(top--);
    }

}
