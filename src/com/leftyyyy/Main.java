package com.leftyyyy;

import com.leftyyyy.linkedList.LinkListFactory;
import com.leftyyyy.linkedList.Node;

public class Main {
    public static void main(String[] args) {
        LinkListFactory ll = new LinkListFactory();
        Node head = ll.createLinkedList(1);
        head = ll.addToLinkedListLast(head,2);
        head = ll.addToLinkedListLast(head, 3);
        head = ll.addToLinkedListLast(head, 4);
        ll.printLinkedList(head);
        System.out.println(ll.getLength(head));

        //delete
        head = ll.deleteNode(head, 4);
        ll.printLinkedList(head);

        //insert
        head = ll.insertAtI(head,1,4);
        ll.printLinkedList(head);
    }
}
