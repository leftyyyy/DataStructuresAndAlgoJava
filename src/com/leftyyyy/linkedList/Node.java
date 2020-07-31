package com.leftyyyy.linkedList;

public class Node {

    Node(int data){
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public int getData() {
        return this.data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    private Node nextNode;
    private int data;
}
