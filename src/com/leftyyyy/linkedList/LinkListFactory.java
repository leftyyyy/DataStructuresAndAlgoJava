package com.leftyyyy.linkedList;

public class LinkListFactory {

    public Node createLinkedList(int data){
        Node head = new Node(data);
        return head;
    }

    public Node addToLinkedListLast(Node head, int data){
        Node tmp = head;
        while(tmp.getNextNode() != null){
            tmp = tmp.getNextNode();
        }
        Node newNode = new Node(data);
        tmp.setNextNode(newNode);
        tmp = null;
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

    public int getLength(Node head){
        Node tmp = head;
        int count = 0;
        while(tmp != null){
            count = count + 1;
            tmp = tmp.getNextNode();
        }
        return count;
    }

    public Node deleteNode(Node head, int data){
        Node curr = head;
        if(curr.getData()==data){
            head = head.getNextNode();
            curr.setNextNode(null);
            return head;
        }
        while(curr.getNextNode().getNextNode()!=null && curr.getNextNode().getData()!=data){
            curr = curr.getNextNode();
        }
        if(curr.getNextNode().getData()==data){
            Node next = curr.getNextNode();
            curr.setNextNode(curr.getNextNode().getNextNode());
            next.setNextNode(null);
        }
        return head;
    }

    public Node insertAtI(Node head, int i, int data){
        if(i<0 || i>getLength(head)){
            return head;
        }
        int count = 0;
        Node prev = null;
        Node curr = head;
        while(count<i){
            prev = curr;
            curr = curr.getNextNode();
            count = count + 1;
        }
        Node newNode = new Node(data);
        if(prev==null){
            head = newNode;
        }else{
            prev.setNextNode(newNode);
        }
        newNode.setNextNode(curr);
        return head;
    }
}
