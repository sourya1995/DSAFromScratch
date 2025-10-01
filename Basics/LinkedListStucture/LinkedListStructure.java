package Basics.LinkedListStucture;

import java.util.logging.Logger;

public class LinkedListStructure {
    private static final Logger logger = Logger.getLogger(LinkedListStructure.class.getName());
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
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
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
            throw new IllegalStateException("List is empty");
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        if (current.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
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
        logger.info(sb.toString());
    }
}