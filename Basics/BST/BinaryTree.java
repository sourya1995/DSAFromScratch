package Basics.BST;

import java.util.logging.Logger;
import java.util.logging.Level;

public class BinaryTree {
    private static final Logger logger = Logger.getLogger(BinaryTree.class.getName());
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Insert a new node with given data
    public void insert(int data) {
        root = insertRec(root, data);
        logger.log(Level.INFO, "Inserted node with data: " + data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // In-order traversal (left -> root -> right)
    public void inOrder() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot perform in-order traversal.");
        }
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            logger.log(Level.INFO, root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal (root -> left -> right)
    public void preOrder() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot perform pre-order traversal.");
        }
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            logger.log(Level.INFO, root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal (left -> right -> root)
    public void postOrder() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot perform post-order traversal.");
        }
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            logger.log(Level.INFO, root.data + " ");
        }
    }

    // Search for a value in the tree
    public boolean search(int key) throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot search.");
        }
        return searchRec(root, key);
    }

    private boolean searchRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        return key < root.data ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Delete a node with given key
    public void delete(int key) throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot delete node with key: " + key);
        }
        root = deleteRec(root, key);
        logger.log(Level.INFO, "Deleted node with data: " + key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        }
        else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        }
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Get the height of the tree
    public int height() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, height is undefined.");
        }
        return heightRec(root);
    }

    private int heightRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Get the size of the tree (number of nodes)
    public int size() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, size is 0.");
        }
        return sizeRec(root);
    }

    private int sizeRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sizeRec(root.left) + sizeRec(root.right) + 1;
    }

    // Get the maximum value in the tree
    public int maxValue() throws TreeException {
        if (root == null) {
            throw new TreeException("Tree is empty, cannot find maximum value.");
        }
        return maxValueRec(root);
    }

    private int maxValueRec(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE; // Should not reach here if root is checked in maxValue()
        }
        int maxv = root.data;
        int leftMax = maxValueRec(root.left);
        int rightMax = maxValueRec(root.right);
        if (leftMax > maxv) {
            maxv = leftMax;
        }
        if (rightMax > maxv) {
            maxv = rightMax;
        }
        return maxv;
    }

}
