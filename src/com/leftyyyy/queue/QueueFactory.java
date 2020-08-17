package com.leftyyyy.queue;

public class QueueFactory {
    public static void main(String[] args) {
        QueueUsingArrayList q = new QueueUsingArrayList();
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


        System.out.println("queue using LL");
        QueueUsingLinkedList q_new = new QueueUsingLinkedList();
        q_new.enqueue('r');
        q_new.enqueue('i');
        q_new.enqueue('s');
        q_new.enqueue('h');
        q_new.enqueue('i');

        while(!q_new.isEmpty()){
            System.out.println(q_new.front());
            q_new.dequeue();
        }
        System.out.println(q_new.dequeue());
    }
}
