package com.company.lvl2;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Element " + value + "wasn't found.");
        } else {
            current.next = current.next.next;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        System.out.println("The contents of the list:");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
