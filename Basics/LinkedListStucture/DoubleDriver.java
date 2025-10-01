package Basics.LinkedListStucture;

public class DoubleDriver {
    public static void main(String[] args) {
        DoublyLinkedListStructure dll = new DoublyLinkedListStructure();

        // Insert elements at the head
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(30);

        // Insert elements at the end
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);

        // Add element at specific position
        dll.addAtPosition(25, 2); // Position is 0-based

        // The list should now be: 30 <-> 20 <-> 25 <-> 10 <-> 40 <-> 50
        dll.printListForward();
    }
}
