package Basics.DoubleEndedQueue;

import java.util.logging.Logger;

public class DoubleEndedQueue {
    // insertFront() insertion happens at the front end
    // insertRear() insertion happens at the rear end
    // deleteFront() deletion happens at the front end
    // deleteRear() deletion happens at the rear end
    // getFront() returns the front element
    // getRear() returns the rear element
    // isEmpty() checks if the deque is empty
    // printDeque() prints all the elements in the deque

    int[] dequeArray;
    int front;
    int rear;
    int capacity;
    int size;

    private static final Logger logger = Logger.getLogger(DoubleEndedQueue.class.getName());

    public DoubleEndedQueue(int size) {
        dequeArray = new int[size];
        capacity = size;
        front = -1;
        rear = 0;
        this.size = 0;
    }

    public void insertFront(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Deque Overflow");
        } else {
            if (front == -1) { // If deque is initially empty
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = capacity - 1; // Wrap around
            } else {
                front--;
            }
            dequeArray[front] = value;
            size++;
        }
    }

    public void insertRear(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Deque Overflow");
        } else {
            if (front == -1) { // If deque is initially empty
                front = 0;
                rear = 0;
            } else if (rear == capacity - 1) {
                rear = 0; // Wrap around
            } else {
                rear++;
            }
            dequeArray[rear] = value;
            size++;
        }
    }

    public int deleteFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque Underflow");
        } else {
            int element = dequeArray[front];
            if (front == rear) { // Only one element was present
                front = -1;
                rear = -1;
            } else if (front == capacity - 1) {
                front = 0; // Wrap around
            } else {
                front++;
            }
            size--;
            return element;
        }
    }

    public int deleteRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque Underflow");
        } else {
            int element = dequeArray[rear];
            if (front == rear) { // Only one element was present
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = capacity - 1; // Wrap around
            } else {
                rear--;
            }
            size--;
            return element;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return dequeArray[front];
    }

    public int getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return dequeArray[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (isEmpty()) {
            logger.info("Deque is empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(dequeArray[(front + i) % capacity]).append(" ");
            }
            logger.info(() -> String.format("Deque elements: %s", sb.toString().trim()));
        }
    }
}
