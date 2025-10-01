package Basics.LinkedListStucture;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDriver {
    private static final Logger logger = Logger.getLogger(MainDriver.class.getName());

    public static void main(String[] args) {
        LinkedListStructure linkedList = new LinkedListStructure();
        linkedList.insertAtHead(10);
        linkedList.printList();
        linkedList.insertAtHead(20);
        linkedList.printList();
        linkedList.insertAtEnd(30); // List: 20 -> 10 -> 30
        linkedList.printList();
        try {
            linkedList.addAtPosition(25, 1); // List: 20 -> 25 -> 10 -> 30
        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        linkedList.printList();
        linkedList.delete(10); // List: 20 -> 25 -> 30  // Deleting node with value 10
        linkedList.printList();

        logger.info("\nAdding 5 more elements:");
        linkedList.insertAtEnd(40);
        linkedList.printList();
        linkedList.insertAtEnd(50);
        linkedList.printList();
        linkedList.insertAtEnd(60);
        linkedList.printList();
        linkedList.insertAtEnd(70);
        linkedList.printList();
        linkedList.insertAtEnd(80);
        linkedList.printList();

        logger.info("\nRemoving last 2 elements:");
        linkedList.deleteAtEnd();
        linkedList.printList();
        linkedList.deleteAtEnd();
        linkedList.printList();

        logger.info("\nTrying to delete at an invalid position:");
        try {
            linkedList.deleteAtPosition(100);
        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Exception caught: " + e.getMessage());
        }
    }
}