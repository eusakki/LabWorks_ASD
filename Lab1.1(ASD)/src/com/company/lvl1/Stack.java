package com.company.lvl1;
import java.util.ArrayList;

public class Stack {
    private ArrayList<String> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void add(String value) {
        elements.add(value);
    }

    private boolean isEmpty() {
        return elements.isEmpty();
    }

    public String delete() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("The contents of the stack:");
        for (int i = elements.size() - 1; i >= 0; i--) {
            System.out.println(elements.get(i));
        }
    }
}
