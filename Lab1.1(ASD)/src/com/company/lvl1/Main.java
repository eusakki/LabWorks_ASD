package com.company.lvl1;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.add("25");    //21
        stack.add("123");   //83
        stack.add("52");    //42
        stack.add("6");     //6

        System.out.println("Added elements:");
        stack.printStack();

        stack.delete();
        stack.delete();

        System.out.println("Deleted two elements:");
        stack.printStack();
    }
}
