package Sorting;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class TreeSort {
    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void inOrderTraversal(Node root, int[] arr, int[] index) {
        if (root != null) {
            inOrderTraversal(root.left, arr, index);
            arr[index[0]++] = root.key;
            inOrderTraversal(root.right, arr, index);
        }
    }

    void treeSort(int[] arr) {
        root = null;
        for (int key : arr) {
            insert(key);
        }
        int[] index = {0};
        inOrderTraversal(root, arr, index);
    }
}
