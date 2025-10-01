package Basics.LinkedListStucture;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DoubleDriver {
    private static final Logger logger = Logger.getLogger(DoubleDriver.class.getName());

    public static void main(String[] args) {
        DoublyLinkedListStructure dll = new DoublyLinkedListStructure();

        // Insert elements at the head
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(30);
        dll.printListForward();

        // Insert elements at the end
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.printListForward();

        // Add element at specific position
        try {
            dll.addAtPosition(25, 2); // Position is 0-based
        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        // The list should now be: 30 <-> 20 <-> 25 <-> 10 <-> 40 <-> 50
        logger.info("Forward list:");
        dll.printListForward();
        logger.info("Backward list:");
        dll.printListBackward();

        logger.info("\nDeleting node with value 25:");
        dll.delete(25);
        dll.printListForward();

        logger.info("\nDeleting last node:");
        dll.deleteAtEnd();
        dll.printListForward();

        logger.info("\nTrying to delete at an invalid position:");
        try {
            dll.deleteAtPosition(100);
        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Exception caught: " + e.getMessage());
        }
    }
}