package com.leftyyyy.doublyLinkedList;

public class DoublyLinkedListFactory {
    public Node createLinkedList(int data){
        Node head = new Node(data);
        return head;
    }

    public Node addToLinkedList(Node head, int data){
        Node tmp = head;
        if(tmp.getData()>=data){
            Node newNode = new Node(data);
            newNode.setNextNode(tmp);
            tmp.setPrevNode(newNode);
            head = newNode;
            return head;
        }
        while(tmp.getNextNode()!=null && tmp.getNextNode().getData()<data){
            tmp=tmp.getNextNode();
        }
        Node newNode = new Node(data);
        if(tmp.getNextNode()==null && tmp.getData()<=data){
            tmp.setNextNode(newNode);
            newNode.setPrevNode(tmp);
            return head;
        }
        if(tmp.getNextNode().getData()>=newNode.getData()){
            Node t = tmp.getNextNode();
            tmp.setNextNode(newNode);
            newNode.setNextNode(t);
            t.setPrevNode(newNode);
            newNode.setPrevNode(tmp);
        }
        return head;
    }

    public void printLinkedList(Node head){
        Node t = head;
        System.out.print("None --><--");
        while(t != null) {
            System.out.print(t.getData() + "--><--");
            t = t.getNextNode();
        }
        System.out.print("None");
        System.out.println();
    }

    public Node deleteNode(Node head, int data){
        Node curr = head;
        if(curr.getData()==data){
            curr = curr.getNextNode();
            head = curr;
            head.setPrevNode(null);
            return head;
        }
        while(curr.getNextNode().getNextNode()!=null && curr.getNextNode().getData()!=data){
            curr = curr.getNextNode();
        }
        if(curr.getNextNode().getData()==data){
            Node next = curr.getNextNode();
            curr.setNextNode(curr.getNextNode().getNextNode());
            next.setNextNode(null);
            next.setPrevNode(null);
        }

        return head;
    }
}
