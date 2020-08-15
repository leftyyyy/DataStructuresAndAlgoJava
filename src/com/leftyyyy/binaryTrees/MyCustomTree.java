package com.leftyyyy.binaryTrees;
import java.util.ArrayList;
import java.util.Scanner;
public class MyCustomTree {


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

    public static int numNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = numNodes(root.getLeft());
        int rightCount = numNodes(root.getRight());
        return 1+leftCount+rightCount;
    }
    //postOrder
    public static Node printTreePostOrder(Node root){
        if(root == null){
            return null;
        }
        printTreePostOrder(root.getLeft());
        printTreePostOrder(root.getRight());
        System.out.print(root.getData() + " ");
        return null;
    }

    //preOrder
    public static Node printTreePreOrder(Node root){
        if(root == null){
            return null;
        }
        System.out.print(root.getData());
        if(root.getLeft()!=null){
            System.out.print(" : L->" + root.getLeft().getData());
        }
        if(root.getRight()!=null){
            System.out.print(" , R->" + root.getRight().getData());
        }
        System.out.println();
        printTreePreOrder(root.getLeft());
        printTreePreOrder(root.getRight());
        return null;
    }

    //inOrder
    public static Node printTreeInOrder(Node root){
        if(root == null){
            return null;
        }
        printTreeInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        printTreeInOrder(root.getRight());
        return null;
    }

    //largest data in tree
    public static int largestData(Node root){
        if(root == null){
            return -1;
        }
        int leftLargest = largestData(root.getLeft());
        int rightLargest = largestData(root.getRight());
        if(leftLargest>rightLargest && leftLargest>root.getData()){
            return leftLargest;
        }else if(rightLargest>root.getData()){
            return rightLargest;
        }else{
            return root.getData();
        }
    }

    //height of tree. single node is having 1 height.
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftTree = 1+heightOfTree(root.getLeft());
        int rightTree = 1+heightOfTree(root.getRight());
        if(leftTree>rightTree){
            return leftTree;
        }else{
            return rightTree;
        }
    }

    //get leaf nodes (number of leaf nodes)
    public static int leafNode(Node root){
        if(root == null){
            return 0;
        }
        if(root.getLeft()==null && root.getRight()==null){
            return 1;
        }
        int leftTree = leafNode(root.getLeft());
        int rightTree = leafNode(root.getRight());
        return leftTree + rightTree;
    }

    //all the nodes at dept K -- root is at dept 0
    public static Node nodeAtDeptK(Node root, int k){
        if(root == null){
            return null;
        }
        if(k==0){
            System.out.println(root.getData());
            return root;
        }
        nodeAtDeptK(root.getLeft(), k-1);
        nodeAtDeptK(root.getRight(), k-1);
        return null;
    }
    //all nodes at dept k version 2 [initial dept should be 0]
    public static Node nodeAtDeptKV2(Node root, int k, int dept){
        if(root == null){
            return null;
        }
        if(k==dept){
            System.out.println(root.getData());
            return root;
        }
        nodeAtDeptKV2(root.getLeft(), k, dept+1);
        nodeAtDeptKV2(root.getRight(), k, dept+1);
        return null;
    }

    public static Node removeLeafNodes(Node root){
        if(root == null){
            return null;
        }
        //if root is leaf
        if(root.getLeft()==null && root.getRight()==null){
            return null;
        }
        root.setLeft(removeLeafNodes(root.getLeft()));
        root.setRight(removeLeafNodes(root.getRight()));
        return root;
    }

    public static void main(String[] args) {
        Node root = treeInput();
        System.out.println("Number of nodes are: " + numNodes(root));
        System.out.println("preOrder : Root-Left-Right");
        printTreePreOrder(root);
        System.out.println("postOrder: Left-Right-Root");
        printTreePostOrder(root);
        System.out.println();
        System.out.println("InOrder: Left-Root-Right");
        printTreeInOrder(root);
        System.out.println();
        System.out.println("LargestNumber");
        System.out.println(largestData(root));
        System.out.println();
        System.out.println("Height of tree is: " + heightOfTree(root));
        System.out.println();
        System.out.println("number of leaf nodes are: " + leafNode(root));
        System.out.println("node at dept K are ---> ");
        nodeAtDeptK(root, 1);
        System.out.println("using version 2: --->");
        nodeAtDeptKV2(root, 1, 0);

        System.out.println("Tree after removing leaf nodes");
        printTreePreOrder(removeLeafNodes(root));
    }
}