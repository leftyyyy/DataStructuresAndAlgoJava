package com.leftyyyy.queue;

public class Node {

    Node(Character data){
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Character getData() {
        return this.data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    private Node nextNode;
    private Character data;
}
