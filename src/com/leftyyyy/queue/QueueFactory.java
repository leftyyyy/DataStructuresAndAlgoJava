package com.leftyyyy.queue;

public class QueueFactory {
    public static void main(String[] args) {
        Queues q = new Queues();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');
        q.enqueue('e');
        while(!q.isEmpty()){
            System.out.println(q.front());
            q.dequeue();
        }
        System.out.println(q.dequeue());
    }
}
