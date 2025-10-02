package Basics.NAryTree;

import java.util.logging.Logger;

public class MainDriver {
    private static Logger logger = Logger.getLogger(MainDriver.class.getName());

    public static void main(String[] args) {
        try {
            NaryTree tree = new NaryTree(1);
            tree.root.children.add(new NNode(2));
            tree.root.children.add(new NNode(3));
            tree.root.children.add(new NNode(4));
            tree.root.children.get(0).children.add(new NNode(5));
            tree.root.children.get(0).children.add(new NNode(6));
            tree.root.children.get(1).children.add(new NNode(7));
            tree.root.children.get(1).children.add(new NNode(8));
            tree.root.children.get(2).children.add(new NNode(9));
            tree.root.children.get(2).children.add(new NNode(10));

            logger.info("Pre-order traversal:");
            tree.preOrder(tree.root);

            logger.info("\nPost-order traversal:");
            tree.postOrder(tree.root);

            logger.info("\nIn-order traversal:");
            tree.inOrder(tree.root);

            logger.info("\nLevel-order traversal:");
            tree.levelOrder();

            logger.info("\nSearching for value 5:");
            boolean found = tree.search(tree.root, 5);
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("Value found: %b", found));
            }

            logger.info("\nTriggering NodeNotFoundException with null node:");
            tree.preOrder(null); // This should trigger the exception

        } catch (NodeNotFoundException e) {
            logger.severe("Exception occurred: " + e.getMessage());
        }

        try {
            logger.info("\nTriggering NodeNotFoundException with null root:");
            NaryTree nullRootTree = new NaryTree(0); // Create a tree with a root, then set it to null to trigger the exception in levelOrder
            nullRootTree.root = null;
            nullRootTree.levelOrder();
        } catch (NodeNotFoundException e) {
            logger.severe("Exception occurred: " + e.getMessage());
        }
    }
}
