package com.leftyyyy.priorityQueues;

import java.util.ArrayList;

public class PriorityQueueMain {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert('a', 3);
        pq.insert('b', 4);
        pq.insert('c', 63);
        pq.insert('d', 21);
        System.out.println(pq.getMin().getData());
        pq.insert('e',4);
        pq.removeMin();
        for (PriorityQueueNode i: pq.getQ()
        ) {
            System.out.print(i.getData() + " ");
        }
    }
}
