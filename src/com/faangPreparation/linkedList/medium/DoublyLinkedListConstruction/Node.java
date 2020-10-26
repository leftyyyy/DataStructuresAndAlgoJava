package com.faangPreparation.linkedList.medium.DoublyLinkedListConstruction;

public class Node {
    private Node next;
    private Node prev;
    private int value;

    Node(int data){
        this.value = data;
    }
    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nextNode) {
        this.next = nextNode;
    }

    public Node getPrevNode() {
        return prev;
    }

    public void setPrevNode(Node prevNode) {
        this.prev = prevNode;
    }

    public int getValue() {
        return value;
    }
}
