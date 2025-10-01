package Basics.LinkedListStucture;

public class LinkedListStructure {
    Node head;

    public LinkedListStructure() {
        this.head = null;
    }

    // insert at the beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add a new node to the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add a new node at a specific position
    public void addAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtEnd(data);
            return;
        }

        Node current = head;
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
        current.next = newNode;
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
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
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
    }

    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void printList() {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        String separator = " -> ";
        while (current != null) {
            sb.append(current.data).append(separator);
            current = current.next;
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - separator.length());
        }
        System.out.println(sb.toString());
    }
}
