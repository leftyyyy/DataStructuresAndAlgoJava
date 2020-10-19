package com.faangPreparation.linkedList.medium.linkedListConstruction;

//construction of a doubly linked list
//with head and tail
public class LinkedListConstruction {
    private Node head;
    private Node tail;
    LinkedListConstruction(){
        this.head = null;
        this.tail = null;
    }

    public void setHead(Node node) {
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        this.insertBefore(this.head, node);
    }

    public Node getHead() {
        return head;
    }

    public void setTail(Node node) {
        if(this.tail == null){
            this.setHead(node);
            return;
        }
        this.insertAfter(this.tail, node);
    }

    public Node getTail() {
        return tail;
    }

    public void insertBefore(Node node, Node nodeToInsert){
        if(nodeToInsert==this.head && nodeToInsert==this.tail){
            return;
        }
        this.remove(nodeToInsert);
        nodeToInsert.setPrevNode(node.getPrevNode());
        nodeToInsert.setNextNode(node);
        if(node.getPrevNode() == null){
            this.head = nodeToInsert;
        }else{
            node.getPrevNode().setNextNode(nodeToInsert);
        }
        node.setPrevNode(nodeToInsert);
    }

    public void insertAfter(Node node, Node nodeToInsert){
        if(nodeToInsert==this.head && nodeToInsert==this.tail){
            return;
        }
        this.remove(nodeToInsert);
        nodeToInsert.setPrevNode(node);
        nodeToInsert.setNextNode(node.getNextNode());
        if(node.getNextNode() == null){
            this.tail = nodeToInsert;
        }else{
            node.getNextNode().setPrevNode(nodeToInsert);
        }
        node.setNextNode(nodeToInsert);
    }

    public void insertAtPosition(int position, Node nodeToInsert){
        if(position==1){
            this.setHead(nodeToInsert);
            return;
        }
        Node node = this.head;
        int currentPosition = 1;
        while(node!=null && currentPosition!=position){
            node = node.getNextNode();
            currentPosition +=1;
        }
        if(node!=null){
            this.insertBefore(node, nodeToInsert);
        }else{
            this.setTail(nodeToInsert);
        }
    }

    public void removeNodeWithValue(int data){
        Node node = this.head;
        while(node!=null){
            Node nodeToRemove = node;
            node = node.getNextNode();
            if(nodeToRemove.getValue()==data){
                this.remove(nodeToRemove);
            }
        }
    }

    public void remove(Node node){
        if(node == this.head){
            this.head = this.head.getNextNode();
        }
        if(node == this.tail){
            this.tail = this.tail.getPrevNode();
        }
        this.removeNodeBindings(node);
    }

    public void removeNodeBindings(Node node){
        if(node.getPrevNode()!=null){
            node.getPrevNode().setNextNode(node.getNextNode());
        }
        if(node.getNextNode()!=null){
            node.getNextNode().setPrevNode(node.getPrevNode());
        }
        node.setPrevNode(null);
        node.setNextNode(null);
    }

    public boolean containsNodeWithValue(int value){
        Node node = this.head;
        while(node!=null && node.getValue() != value){
            node = node.getNextNode();
        }
        return node!=null;
    }
}