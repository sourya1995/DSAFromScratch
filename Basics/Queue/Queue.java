package Basics.Queue;

import java.util.logging.Logger;

public class Queue {
    

    //insert() insertion happens at the rear end
    //remove() deletion happens at the front end
    //peek() returns the front element
    //isEmpty() checks if the queue is empty
    //printQueue() prints all the elements in the queue

    private static final Logger logger = Logger.getLogger(Queue.class.getName());

    int[] queue;
    int front;
    int rear;
    int capacity;
    int size;

    public Queue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
    }
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Queue Overflow");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            logger.info(() -> value + " inserted to queue");
        }
    }

    public int remove() {
        if (isEmpty()) {
            logger.warning("Queue Underflow");
            return -1;
        } else {
            int element = queue[front];
            front = (front + 1) % capacity;
            size--;
            logger.info(() -> element + " removed from queue");
            return element;
        }
    }

    public int peek() {
        if (isEmpty()) {
            logger.info("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        if (isEmpty()) {
            logger.info("Queue is empty");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(queue[(front + i) % capacity]).append(" ");
            }
            logger.info(() -> "Queue elements: " + sb.toString().trim());
        }
    }
}
