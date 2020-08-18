package com.leftyyyy.huffman;


public class BinaryTreeNode {
    private Character data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int freq;

    BinaryTreeNode(Character data, int freq){
        this.data = data;
        left = null;
        right = null;
        this.freq = freq;
    }

    public Character getData() {
        return this.data;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getFreq() {
        return this.freq;
    }
}
