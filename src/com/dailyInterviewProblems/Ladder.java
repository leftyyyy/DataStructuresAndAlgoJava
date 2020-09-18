package com.dailyInterviewProblems;

import java.math.BigInteger;

class Node {
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

public class Ladder {
    public static BigInteger totalWays(int n)
    {
        Node root = new Node(n);
        Node head = root;
        int i=0;
        while(i<n){
            if(n-2==1 || n-1==1){
                Node rightData = new Node(0);
                Node leftData = null;
                head.setLeft(leftData);
                head.setRight(rightData);
            }else if(n-2==0 || n-1==0){
                Node rightData = null;
                Node leftData = null;
                head.setLeft(leftData);
                head.setRight(rightData);
            }else{
                Node leftData = new Node(n-2);
                Node rightData = new Node(n-1);
                head.setLeft(leftData);
                head.setRight(rightData);
            }
            i=i+1;
        }
        return BigInteger.valueOf(1);
    }

    public static void main(String[] args)
    {
        int n = 4;

        System.out.println(totalWays(n));
    }
}
