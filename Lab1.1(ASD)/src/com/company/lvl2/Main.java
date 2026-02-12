package com.company.lvl2;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Added elements:");
        list.printList();

        list.delete(10);
        list.delete(30);

        System.out.println("Deleted two elements:");
        list.printList();
    }
}
