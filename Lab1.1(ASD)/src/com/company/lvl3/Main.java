package com.company.lvl3;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Stack stack = new Stack();

        list.add(10);
        list.add(-21);
        list.add(-6);
        list.add(20);
        list.add(-42);
        list.add(30);

        System.out.println("Added elements:");
        list.printList();

        list.remInvNegativeElements(stack);

        System.out.println("List after changes:");
        list.printList();

        System.out.println("Stack after changes:");
        stack.printStack();
    }
}
