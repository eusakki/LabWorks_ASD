package com.company.lvl3;
import java.util.ArrayList;

public class Stack {
    private String[] elements;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        elements = new String[capacity];
        top = -1;
    }

    public void add(String value) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
            return;
        }
        elements[++top] = value;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public String delete() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return elements[top--];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("The elements of the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(elements[i]);
        }
    }
}
