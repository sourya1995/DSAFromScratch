package Basics.Stack;

import java.util.logging.Logger;
import java.util.logging.Level;

public class StackImpl {
    private static final Logger logger = Logger.getLogger(StackImpl.class.getName());

    public static void main(String[] args) {
        Stacker stack = new Stacker(5);
        try {
            logger.log(Level.INFO, "Top element is: {0}", stack.peek());
        } catch (IllegalStateException e) {
            logger.severe("Exception caught: " + e.getMessage());
        }

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.printStack();
            stack.push(60); // This should cause an overflow
        } catch (IllegalStateException e) {
            logger.severe("Exception caught: " + e.getMessage());
        }

        stack.printStack();

        try {
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
            logger.log(Level.INFO, "Popped element is: {0}", stack.pop()); // This should cause an underflow
        } catch (IllegalStateException e) {
            logger.severe("Exception caught: " + e.getMessage());
        }

        stack.printStack();
        logger.log(Level.INFO, "Is stack empty? {0}", stack.isEmpty());
    }
}
