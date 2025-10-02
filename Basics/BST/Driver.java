package Basics.BST;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Driver {
    private static final Logger logger = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*
         * Let's construct a binary tree
         *         45
         *        /  \\
         *       10   90
         *      /  \\
         *     7   12
         */
        tree.insert(45);
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(90);

        try {
            logger.log(Level.INFO, "In-order traversal:");
            tree.inOrder();
            logger.log(Level.INFO, "\nPre-order traversal:");
            tree.preOrder();
            logger.log(Level.INFO, "\nPost-order traversal:");
            tree.postOrder();

            logger.log(Level.INFO, "\n\nSearch for 12: " + tree.search(12));
            logger.log(Level.INFO, "Search for 100: " + tree.search(100));

            logger.log(Level.INFO, "\nHeight of the tree: " + tree.height());
            logger.log(Level.INFO, "Size of the tree: " + tree.size());
            logger.log(Level.INFO, "Maximum value in the tree: " + tree.maxValue());

            logger.log(Level.INFO, "\nDeleting 12:");
            tree.delete(12);
            logger.log(Level.INFO, "In-order traversal after deleting 12:");
            tree.inOrder();

            logger.log(Level.INFO, "\nDeleting 90:");
            tree.delete(90);
            logger.log(Level.INFO, "In-order traversal after deleting 90:");
            tree.inOrder();

            logger.log(Level.INFO, "\nDeleting 45 (root):");
            tree.delete(45);
            logger.log(Level.INFO, "In-order traversal after deleting 45:");
            tree.inOrder();

            // Exception trigger scenarios
            logger.log(Level.INFO, "\nAttempting to get max value from an empty tree:");
            BinaryTree emptyTree = new BinaryTree();
            emptyTree.maxValue();

        } catch (TreeException e) {
            logger.log(Level.SEVERE, "TreeException caught: " + e.getMessage());
        }
    }
}
