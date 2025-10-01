package Basics.LinkedListStucture;

public class DoublyLinkedListStructure {
    DoubleNode head;

    public DoublyLinkedListStructure() {
        this.head = null;
    } 

    // insert at the beginning
    public void insertAtHead(int data) {
        DoubleNode newNode = new DoubleNode(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }
   

    // Add a new node to the end of the list
    public void insertAtEnd(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoubleNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }


    // Add a new node at a specific position
    public void addAtPosition(int data, int position) {
        DoubleNode newNode = new DoubleNode(data);
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        DoubleNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
    }


    // Delete a node by value
    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        DoubleNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            }
        }
    }


    // Delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        DoubleNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) { 
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            }
        } else {
            System.out.println("Position out of bounds");
        }
    }


    // Delete a node at the end
    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        DoubleNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
    }   

    // search for a value in the list
    public boolean search(int key) {
        DoubleNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // print forward
    public void printListForward() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // print backward
    public void printListBackward() {
        DoubleNode current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
