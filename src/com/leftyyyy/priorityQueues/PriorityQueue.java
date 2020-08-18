package com.leftyyyy.priorityQueues;

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue {
    private ArrayList<PriorityQueueNode> pq;
    PriorityQueue(){
        pq = new ArrayList<PriorityQueueNode>();
    }

    public Boolean isEmpty(){
        return this.getSize() == 0;
    }

    public int getSize(){
        return this.pq.size();
    }

    public PriorityQueueNode getMin(){
        if(this.isEmpty()){
            return null;
        }
        return this.pq.get(0);
    }

    private void percolateUp(){
        int childIndex = this.getSize() - 1;
        while(childIndex > 0){
            int parentIndex = (childIndex - 1)/2;
            if(this.pq.get(parentIndex).getPriority() > this.pq.get(childIndex).getPriority()){
                Collections.swap(pq, parentIndex, childIndex);
                childIndex = parentIndex;
            }else{
                break;
            }
        }
    }
    public void insert(Character data, int priority){
        PriorityQueueNode pqNode = new PriorityQueueNode(data, priority);
        this.pq.add(pqNode);
        this.percolateUp();
    }

    private void percolateDown(){
        int parentIndex = 0;
        int leftIndex = 2*parentIndex;
        int rightIndex = 2*parentIndex + 1;
        while(leftIndex < this.getSize()){
            int minIndex = parentIndex;
            if(this.pq.get(minIndex).getPriority() > this.pq.get(leftIndex).getPriority()){
                minIndex = leftIndex;
            }
            if(rightIndex < this.getSize() && (this.pq.get(minIndex).getPriority() > this.pq.get(rightIndex).getPriority())){
                minIndex = rightIndex;
            }
            if(minIndex!=parentIndex){
                Collections.swap(pq, parentIndex, minIndex);
                parentIndex = minIndex;
                leftIndex = 2*parentIndex;
                rightIndex = 2*parentIndex + 1;
            }else{
                break;
            }
        }
    }

    public PriorityQueueNode removeMin(){
        if(this.isEmpty()){
            return null;
        }
        /*
        System.out.println("BEFORE");
        for ( PriorityQueueNode i: pq
             ) {
            System.out.print(i.getData() + " ");
        }

         */
        PriorityQueueNode element = this.pq.get(0);
        this.pq.add(0, this.pq.get(this.pq.size()-1));
        this.pq.remove(this.pq.size()-1);
        this.percolateDown();
        /*
        System.out.println();
        System.out.println("after");
        for ( PriorityQueueNode i: pq
        ) {
            System.out.print(i.getData() + " ");
        }

         */
        return element;
    }

    public ArrayList<PriorityQueueNode> getQ(){
        return this.pq;
    }
}
