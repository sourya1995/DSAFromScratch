package Basics.NAryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NaryTree {
    NNode root;

    public NaryTree(int rootData) {
        this.root = new NNode(rootData);
    }

    // Pre-order traversal (root -> children)
    public void preOrder(NNode node) throws NodeNotFoundException {
        if(node == null) throw new NodeNotFoundException("Node is null");
        System.out.println(node.data + " ");
        for(NNode child : node.children) {
            preOrder(child);
        }
    }

    // Post-order traversal (children -> root)
    public void postOrder(NNode node) throws NodeNotFoundException {
        if(node == null) throw new NodeNotFoundException("Node is null");
        for(NNode child : node.children) {
            postOrder(child);
        }
        System.out.println(node.data + " ");
    }

    // In-order traversal (left -> root -> right)
    public void inOrder(NNode node) throws NodeNotFoundException {
        if(node == null) throw new NodeNotFoundException("Node is null");
        int size = node.children.size();
        for(int i = 0; i < size; i++) {
            if(i == size / 2) {
                System.out.println(node.data + " ");
            }
            inOrder(node.children.get(i));
        }
        if(size == 0) {
            System.out.println(node.data + " ");
        }
    }

    // Level-order traversal (BFS)
    public void levelOrder() throws NodeNotFoundException {
        if(root == null) throw new NodeNotFoundException("Root is null");
        Queue<NNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            NNode current = queue.poll();
            System.out.println(current.data + " ");
            for(NNode child : current.children) {
                queue.add(child);
            }
        }
    }

    // Search for a value in the tree
    public boolean search(NNode node, int key) throws NodeNotFoundException {
        if(node == null) throw new NodeNotFoundException("Node is null");
        if(node.data == key) return true;
        for(NNode child : node.children) {
            if(search(child, key)) return true;
        }
        return false;
    }
}
