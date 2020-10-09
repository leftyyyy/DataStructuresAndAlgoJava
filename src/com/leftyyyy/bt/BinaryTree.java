package com.leftyyyy.bt;

import java.util.Scanner;

public class BinaryTree {
    public static Node treeInput(){
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if(rootData==-1){
            return null;
        }
        Node root = new Node(rootData);
        Node leftTree = treeInput();
        Node rightTree = treeInput();
        root.setLeft(leftTree);
        root.setRight(rightTree);
        return root;
    }
}
