package Basics.LinkedListStucture;

import java.util.logging.Logger;

public class DoublyLinkedListStructure {
    private static final Logger logger = Logger.getLogger(DoublyLinkedListStructure.class.getName());
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
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
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
            throw new IllegalStateException("List is empty");
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
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            }
        } else {
            throw new IndexOutOfBoundsException("Position out of bounds");
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
        StringBuilder sb = new StringBuilder();
        DoubleNode current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        logger.info(sb.toString().trim());
    }

    // print backward
    public void printListBackward() {
        if (head == null) {
            logger.info("List is empty");
            return;
        }
        DoubleNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.prev;
        }
        logger.info(sb.toString().trim());
    }
}