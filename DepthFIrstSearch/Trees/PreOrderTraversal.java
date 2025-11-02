package DepthFIrstSearch.Trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import Basics.LinkedListStucture.Node;

public class PreOrderTraversal {
    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    
    }

    public static <T> void preOrderTraversal(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f){
        String val = iter.next();
        if(val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);

        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s){
        return s.isEmpty()? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        preOrderTraversal(root);
    }
}
