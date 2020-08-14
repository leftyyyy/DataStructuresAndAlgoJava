package com.leftyyyy;

import com.leftyyyy.doublyLinkedList.DoublyLinkedListFactory;
import com.leftyyyy.doublyLinkedList.Node;
import com.leftyyyy.linkedList.LinkListFactory;
import com.leftyyyy.linkedList.SortedLinkedListFactory;

public class Main {
    public static void main(String[] args) {
        /*
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
        */

        /*
        SortedLinkedListFactory sll = new SortedLinkedListFactory();
        Node head = sll.createLinkedList(1);
        head = sll.addToLinkedList(head, 3);
        head = sll.addToLinkedList(head, 2);
        head = sll.addToLinkedList(head, 10);
        head = sll.addToLinkedList(head, 5);
        head = sll.addToLinkedList(head, 5);
        head = sll.addToLinkedList(head, 0);
        head = sll.addToLinkedList(head, 11);
        sll.printLinkedList(head);
        */

        DoublyLinkedListFactory dll = new DoublyLinkedListFactory();
        Node head = dll.createLinkedList(1);
        head = dll.addToLinkedList(head, 10);
        head = dll.addToLinkedList(head, 5);
        head = dll.addToLinkedList(head, 7);
        head = dll.addToLinkedList(head, 3);

        dll.printLinkedList(head);

        head = dll.deleteNode(head, 100);
        dll.printLinkedList(head);

    }
}
