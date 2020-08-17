package com.leftyyyy.queue;

import java.util.ArrayList;

public class QueueUsingArrayList {
    //enqueue, dequeue, isEmpty, front, size
    private ArrayList<Character> arr;
    private int count;
    private int front;
    QueueUsingArrayList(){
        arr = new ArrayList<Character>();
        count = 0;
        front = 0;
    }
    /*
    public ArrayList getQueue(){
        return this.arr;
    }

     */

    public void enqueue(Character data){
        this.arr.add(data);
        this.count = this.count + 1;
    }

    public Character dequeue(){
        if(this.count == 0){
            return null;
        }

        Character element = this.arr.get(this.front);
        this.front = this.front + 1;
        this.count = this.count - 1;
        return element;

    }

    public Character front(){
        if(this.count == 0){
            return null;
        }
        return this.arr.get(this.front);
    }

    public Boolean isEmpty(){
        return this.size()==0;
    }

    public int size(){
        return this.count;
    }
}
