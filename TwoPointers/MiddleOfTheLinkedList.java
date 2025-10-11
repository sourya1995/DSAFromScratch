package TwoPointers;

import java.util.Iterator;
import java.util.function.Function;

/* Leetcode 876 - Middle of the Linked List */
public class MiddleOfTheLinkedList {
    public static class Node<T>{
        public T data;
        public Node<T> next;
        public Node(T data){
            this(data, null);
        }
        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    public static int middleOfLinkedList(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null) {
            throw new IllegalArgumentException("The linked list is empty.");
        }
        return slow.data;

    }

     public static <T> Node<T> buildList(Iterator<String> iter, Function<String, T> f) {

        if (!iter.hasNext()) return null;

        String val = iter.next();

        Node<T> next = buildList(iter, f);

        return new Node<T>(f.apply(val), next);

    }
}
