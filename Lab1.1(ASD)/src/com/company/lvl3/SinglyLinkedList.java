package com.company.lvl3;

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

    public void remInvNegativeElements(Stack stack) {
        while (head != null && head.data < 0) {
            int value = head.data;
            head = head.next;

            int inverted = -value;
            String octal = Integer.toOctalString(inverted);
            stack.add(octal);
        }

        if (head == null) return;

        Node current = head;
        while (current.next != null) {
            if (current.next.data < 0) {
                int value = current.next.data;
                current.next = current.next.next;

                int inverted = -value;
                String octal = Integer.toOctalString(inverted);
                stack.add(octal);
            } else {
                current = current.next;
            }
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        System.out.println("The contents of the list:");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
