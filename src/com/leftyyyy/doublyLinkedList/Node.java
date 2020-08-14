package com.leftyyyy.doublyLinkedList;

public class Node {
    private Node nextNode;
    private Node prevNode;
    private int data;

    Node(int data){
        this.data = data;
    }
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public int getData() {
        return data;
    }
}
