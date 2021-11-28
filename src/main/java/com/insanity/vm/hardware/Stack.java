package com.insanity.vm.hardware;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack;
    Stack() {
        this.stack = new ArrayList<Integer>();
    }
    public int pop() {
        int top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return top;
    }
    public void push(int value) {
        stack.add(value);
    }
}
