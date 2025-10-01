package Basics.Queue;

import java.util.logging.Logger;

public class QueueImpl {
    private static final Logger logger = Logger.getLogger(QueueImpl.class.getName());

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        logger.info("Is queue empty? " + queue.isEmpty());
        try {
            queue.insert(10);
            queue.insert(20);
            queue.insert(30);
            queue.printQueue();
            logger.log(java.util.logging.Level.INFO, "Peek element: {0}", queue.peek());
            queue.remove();
            queue.printQueue();
            queue.insert(40);
            queue.insert(50);
            queue.insert(60);
            queue.insert(70); // This should show overflow
        } catch (IllegalStateException e) {
            logger.severe("Exception caught: " + e.getMessage());
        }
        queue.printQueue();
        logger.info("Is queue empty? " + queue.isEmpty());
    }

}
