
package com.leftyyyy.binaryTrees;

import org.apache.commons.lang3.tuple.Pair;

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

    public static Boolean isBalanced(Node root){
        if(root == null){
            return Boolean.TRUE;
        }
        int leftHeight = heightOfTree(root.getLeft());
        int rightHeight = heightOfTree(root.getRight());
        if(leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1){
            return Boolean.FALSE;
        }
        Boolean isLeftBalanced = isBalanced(root.getLeft());
        Boolean isRightBalanced = isBalanced(root.getRight());
        if(isLeftBalanced && isRightBalanced){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    public static Pair<Boolean, Integer> getHeightAndCheckBalance(Node root){
        if(root == null){
            Pair<Boolean, Integer> pair = Pair.of(Boolean.TRUE, 0);
            return pair;
        }
        Pair leftRec = getHeightAndCheckBalance(root.getLeft());
        Pair rightRec = getHeightAndCheckBalance(root.getRight());
        Integer lh, rh, h;
        lh = (Integer) leftRec.getValue();
        rh = (Integer) rightRec.getValue();
        if(lh>=rh){
            h = 1 + lh;
        }else{
            h = 1 + rh;
        }
        if(lh-rh>1 || rh-lh>1){
            Pair<Boolean,Integer> pair = Pair.of(Boolean.FALSE, h);
            return pair;
        }
        if((Boolean) leftRec.getKey() && (Boolean) rightRec.getKey()){
            Pair<Boolean,Integer> pair = Pair.of(Boolean.TRUE, h);
            return pair;
        }
        Pair<Boolean,Integer> pair = Pair.of(Boolean.FALSE, h);
        return pair;
    }

    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.getLeft());
        int rightHeight =  heightOfTree(root.getRight());

        int heightSum = leftHeight + rightHeight;

        int leftDia = diameterOfTree(root.getLeft());
        int rightDia = diameterOfTree(root.getRight());

        if(heightSum >= leftDia && heightSum >= rightDia){
            return heightSum;
        }else if(heightSum >= leftDia){
            return rightDia;
        }else{
            return leftDia;
        }
    }

    public static void main(String[] args) {
        Node root = treeInput();
        /*
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

        printTreePreOrder(root);
        System.out.println("isBalanced");
        System.out.println(isBalanced(root));
         */
        printTreePreOrder(root);
        Pair res = getHeightAndCheckBalance(root);
        System.out.println(res.getKey());
        System.out.println(res.getValue());

        System.out.println(diameterOfTree(root));
    }
}