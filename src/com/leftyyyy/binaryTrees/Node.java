package com.leftyyyy.binaryTrees;

public class Node {
    private int data;
    private Node left;
    private Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
