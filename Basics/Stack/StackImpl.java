package Basics.Stack;

import java.util.logging.Logger;
import java.util.logging.Level;

public class StackImpl {
    private static final Logger logger = Logger.getLogger(StackImpl.class.getName());

    public static void main(String[] args) {
        Stacker stack = new Stacker(5);
        logger.log(Level.INFO, "Top element is: {0}", stack.peek());
        stack.push(20);
        stack.push(30);
        stack.printStack();
        logger.log(Level.INFO,"Top element is: {0}", stack.peek());
        logger.log(Level.INFO, "Popped element is: {0}", stack.pop());
        stack.printStack();
        logger.log(Level.INFO, "Is stack empty? {0}", stack.isEmpty());
    }
}
