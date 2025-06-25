/** Purpose of Program: Binary Tree Program checker. Implements a second constructor to create a tree from a string
 * Revise preorder method. Implements isMaxHeap, isBinarySearchTree, inorderList, and Main method.
* Author: Melissa Mandyck Instructor: Duane Jarc  *Date: 06/24/2025 
*Modifications: none      
 */

// CMSC315PROJ3MandyckM Java File

import java.util.*;

public class CompleteBinaryTree {

    protected TreeNode root;
    /**
     * A static nested class representing a node in the binary tree.
     * Contains an integer value and references to left and right children.
     */
    
    public static class TreeNode {
        protected Integer value;
        protected TreeNode left;
        protected TreeNode right;
        
        /**
         * Constructs a TreeNode with a given integer value.
         * 
         * @param value the value to store in the node
         */
        
        public TreeNode(Integer value) {
            this.value = value;
        }
    }
    /**
     * Constructs a CompleteBinaryTree from an array of Integer values that
     * represent a complete binary tree in level-order.
     * 
     * If the input array is not null and contains elements, it initializes the
     * root of the tree by calling the recursive method `makeNode`, starting from
     * index 0.
     * 
     * @param values an array of Integer values representing the binary tree
     *               in level-order
     * @throws InvalidTreeException if the array contains a null element
     *                              where a node is expected
     */
    // Constructor 1: Integer Array
    public CompleteBinaryTree(Integer[] values) throws InvalidTreeException {
        if (values != null && values.length > 0) {
            root = makeNode(values, 0);
        }
    }

    // Constructor 2: Space-Separated String
    public CompleteBinaryTree(String levelOrderValues) throws InvalidTreeException {
        if (levelOrderValues == null || levelOrderValues.trim().isEmpty()) {
            root = null;
            return;
        }

        String[] tokens = levelOrderValues.trim().split("\\s+");
        Integer[] values = new Integer[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new InvalidTreeException("Node value must be an integer.");
            }
        }

        root = makeNode(values, 0);
    }
    /**
     * Recursively constructs a complete binary tree from an array.
     * The array is assumed to represent a complete binary tree in level-order
     * traversal.
     * 
     * For each index `i` in the array:
     * - The element at index `i` represents the node.
     * - The left child of the node is at index `2*i + 1`.
     * - The right child of the node is at index `2*i + 2`.
     * 
     * This method constructs the tree in a level-by-level manner.
     * 
     * @param values array of integer values representing the tree in
     *               level-order
     * @param index  current index in the array that corresponds to the
     *               current node
     * @return TreeNode at the current index, with left and right children
     *         recursively constructed
     * @throws InvalidTreeException if a node value is null or invalid
     */
    protected TreeNode makeNode(Integer[] values, int index) throws InvalidTreeException {
        if (index >= values.length) return null;
        if (values[index] == null) {
            throw new InvalidTreeException("Node element must not be null");
        }

        TreeNode node = new TreeNode(values[index]);
        node.left = makeNode(values, 2 * index + 1);
        node.right = makeNode(values, 2 * index + 2);
        return node;
    }

    /**
     * Performs a preorder traversal of the tree.
     */
    public void preorder() {
        System.out.println("Preorder:"); 
        preorder(root, 0);
    }

    /**
     * Recursive helper method for preorder traversal.
     *
     * @param root the current subtree root
     */
    
    private void preorder(TreeNode node, int level) {
        if (node == null) return;
        System.out.println(" ".repeat(4 * level) + node.value);
        preorder(node.left, level + 1);
        preorder(node.right, level + 1);
    }
// Max Heap
    public boolean isMaxHeap() {
        return isMaxHeap(root);
    }

    private boolean isMaxHeap(TreeNode node) {
        if (node == null) return true;

        boolean leftOK = (node.left == null || node.value >= node.left.value) && isMaxHeap(node.left);
        boolean rightOK = (node.right == null || node.value >= node.right.value) && isMaxHeap(node.right);

        return leftOK && rightOK;
    }
// Binary Search Tree
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        return isBinarySearchTree(node.left, min, node.value)
            && isBinarySearchTree(node.right, node.value, max);
    }
// Makes List In Order
    public ArrayList<Integer> inorderList() {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, ArrayList<Integer> list) { //Puts in Order values
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.value);
        inorder(node.right, list);
    }
}


//ends CMSC315PROJ3MandyckM Java File
