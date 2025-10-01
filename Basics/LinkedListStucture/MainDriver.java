package Basics.LinkedListStucture;

public class MainDriver {
    public static void main(String[] args) {
        LinkedListStructure linkedList = new LinkedListStructure();
        linkedList.insertAtHead(10);
        linkedList.printList();
        linkedList.insertAtHead(20);
        linkedList.printList();
        linkedList.insertAtEnd(30); // List: 20 -> 10 -> 30
        linkedList.printList();
        linkedList.addAtPosition(25, 1); // List: 20 -> 25 -> 10 -> 30
        linkedList.printList();
        linkedList.delete(10); // List: 20 -> 25 -> 30  // Deleting node with value 10
        linkedList.printList();

        System.out.println("\nAdding 5 more elements:");
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

        System.out.println("\nRemoving last 2 elements:");
        linkedList.deleteAtEnd();
        linkedList.printList();
        linkedList.deleteAtEnd();
        linkedList.printList();
    }
}
