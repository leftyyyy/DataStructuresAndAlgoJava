package com.faangPreparation.linkedList.medium.DoublyLinkedListConstruction;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        LinkedListConstruction dll = new LinkedListConstruction();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        Node node7 = new Node(9);
        dll.setHead(node1);
        dll.setTail(node6);
        dll.insertAfter(node1, node2);
        dll.insertAfter(node2, node3);
        dll.insertAfter(node3, node4);
        dll.insertBefore(node6, node5);
        dll.print();
        System.out.println();
        dll.insertAtPosition(3, node7);
        dll.print();
        System.out.println();
        dll.removeNodeWithValue(9);
        dll.remove(node6);
        dll.print();
        System.out.println();
        System.out.println(dll.containsNodeWithValue(5));
        System.out.println(dll.containsNodeWithValue(9));
    }
}
