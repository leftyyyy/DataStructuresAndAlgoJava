package com.leftyyyy.priorityQueues;

public class PriorityQueueNode {
    private Character data;
    private int priority;
    PriorityQueueNode(Character data, int priority){
        this.data = data;
        this.priority = priority;
    }

    public Character getData(){
        return this.data;
    }

    public int getPriority(){
        return this.priority;
    }

}