package com.practice.javacode.trees;

class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value) {
        this.value = value;
    }
}

public class BinarySearchTree {
    BSTNode root;

    // Search a value
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(BSTNode node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;

        if (value < node.value)
            return searchRec(node.left, value);
        else
            return searchRec(node.right, value);
    }

    // Insert a value
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode node, int value) {
        if (node == null) {
            return new BSTNode(value);
        }

        if (value < node.value)
            node.left = insertRec(node.left, value);
        else if (value > node.value)
            node.right = insertRec(node.right, value);

        return node;
    }

    // Delete a value
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private BSTNode deleteRec(BSTNode node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {
            // Case 1: no child
            if (node.left == null && node.right == null)
                return null;

            // Case 2: one child
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            // Case 3: two children
            // Find the successor of node to be deleted. Successor of a node is the least element in the right subtree
            BSTNode successor = minValueNode(node.right);
            node.value = successor.value;
            node.right = deleteRec(node.right, successor.value);
        }
        return node;
    }

    private BSTNode minValueNode(BSTNode node) {
        BSTNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Traversals
    public void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void preorder(BSTNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(BSTNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder: ");
        bst.inorder(bst.root);   // 20 30 40 50 60 70 80

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);  // 50 30 20 40 70 60 80

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);  // 20 40 30 60 80 70 50

        System.out.println("\nSearch 40: " + bst.search(40)); // true

        bst.delete(70);
        System.out.print("After delete: ");
        bst.inorder(bst.root); // 20 30 40 50 60 80
    }
}