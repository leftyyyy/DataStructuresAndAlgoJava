package com.leftyyyy.queue;

public class QueueUsingLinkedList {
    private Node head;
    private Node tail;
    private int count;

    QueueUsingLinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    public void enqueue(Character data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
        this.count = this.count + 1;
    }

    public Character dequeue(){
        if(this.head == null){
            System.out.println("Queue is empty");
            return null;
        }

        Character data = this.head.getData();
        this.head = this.head.getNextNode();
        this.count = this.count - 1;
        return data;
    }

    public Character front(){
        if(this.head == null){
            System.out.println("Queue is empty");
            return null;
        }

        Character data = this.head.getData();
        return data;
    }

    public Boolean isEmpty(){
        return this.size()==0;
    }

    public int size(){
        return this.count;
    }


}
