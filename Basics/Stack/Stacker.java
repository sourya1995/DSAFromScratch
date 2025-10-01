package Basics.Stack;

import java.util.logging.Logger;

class Stacker {
    private static final Logger logger = Logger.getLogger(Stacker.class.getName());
    int[] stack;
    int top;
    int capacity;

    public Stacker(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;

    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow");
        } else {
            stack[++top] = value;
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("%d pushed to stack", value));
            }
        }
    }

    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];

    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        if (isEmpty()) {
            logger.info("Stack is empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = top; i >= 0; i--) {
                sb.append(stack[i]).append(" ");
            }
            logger.info(() -> "Stack elements: " + sb.toString().trim());
        }
    }

}
