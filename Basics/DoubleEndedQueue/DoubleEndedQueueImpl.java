package Basics.DoubleEndedQueue;

import java.util.logging.Logger;

public class DoubleEndedQueueImpl {
    private static final Logger logger = Logger.getLogger(DoubleEndedQueueImpl.class.getName());
    private static final String EXCEPTION_MESSAGE = "Exception caught: ";

    public static void main(String[] args) {
        DoubleEndedQueue deque = new DoubleEndedQueue(5);
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(30);
        deque.insertRear(40);
        deque.printDeque();
        logger.info("Front element: " + deque.getFront());
        logger.info("Rear element: " + deque.getRear());
        deque.deleteFront();
        deque.deleteRear();
        deque.printDeque();
        logger.info("Front element: " + deque.getFront());
        logger.info("Rear element: " + deque.getRear());
    
       try {
            deque.insertFront(50);
            deque.insertFront(60); // This should cause an overflow
        } catch (IllegalStateException e) {
            logger.severe(EXCEPTION_MESSAGE + e.getMessage());
            logger.severe(EXCEPTION_MESSAGE + e.getMessage());
        }
        deque.printDeque();

        try {
            deque.deleteFront();
            deque.deleteRear();
            deque.deleteFront();
            deque.deleteRear(); // This should cause an underflow
        } catch (IllegalStateException e) {
            logger.severe(EXCEPTION_MESSAGE+ e.getMessage());
        }
        deque.printDeque();
        logger.info("Is deque empty? " + deque.isEmpty());

        try {
            logger.info("Front element: " + deque.getFront()); // This should cause an exception
        } catch (IllegalStateException e) {
            logger.severe(EXCEPTION_MESSAGE + e.getMessage());
        }
    }
}
    