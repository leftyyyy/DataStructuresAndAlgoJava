package com.leftyyyy.linkedList;

public class SortedLinkedListFactory {
    public Node createLinkedList(int data){
        Node head = new Node(data);
        return head;
    }

    public Node addToLinkedList(Node head, int data){
        Node tmp = head;
        if(tmp.getData()>=data){
            Node newNode = new Node(data);
            newNode.setNextNode(tmp);
            head = newNode;
            return head;
        }
        while(tmp.getNextNode()!=null && tmp.getNextNode().getData()<data){
            tmp=tmp.getNextNode();
        }
        Node newNode = new Node(data);
        if(tmp.getNextNode()==null && tmp.getData()<=data){
            tmp.setNextNode(newNode);
            tmp=null;
            return head;
        }
        if(tmp.getNextNode().getData()>=newNode.getData()){
            Node t = tmp.getNextNode();
            tmp.setNextNode(newNode);
            newNode.setNextNode(t);
            tmp=null;
            t=null;
        }
        return head;
    }

    public void printLinkedList(Node head){
        Node t = head;
        while(t != null) {
            System.out.print(t.getData() + "-->");
            t = t.getNextNode();
        }
        System.out.print("None");
        System.out.println();
    }
}
