package com.practice.javacode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

// Node class
class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// Binary Tree class
public class BinaryTree {
    BinaryNode root;

    // Level-order traversal
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
        System.out.println();
    }

    // Search for a value
    public boolean search(int value) {
        if (root == null) return false;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();

            if (current.value == value)
                return true;

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
        return false;
    }

    // Insert node in level order
    public void insert(int value) {
        BinaryNode newNode = new BinaryNode(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Delete a node by replacing it with deepest node
    public void delete(int value) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.value == value)
                root = null;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode target = null;
        BinaryNode current = null;
        BinaryNode parentOfDeepest = null;

        while (!queue.isEmpty()) {
            current = queue.remove();

            if (current.value == value)
                target = current;

            if (current.left != null) {
                parentOfDeepest = current;
                queue.add(current.left);
            }

            if (current.right != null) {
                parentOfDeepest = current;
                queue.add(current.right);
            }
        }

        if (target != null) {
            target.value = current.value; // replace with deepest node value
            deleteDeepest(parentOfDeepest, current);
        }
    }

    // Helper to delete deepest node
    private void deleteDeepest(BinaryNode parent, BinaryNode deepest) {
        if (parent == null) {
            root = null;
            return;
        }

        if (parent.right == deepest)
            parent.right = null;
        else
            parent.left = null;
    }

    // Inorder Traversal (Left, Root, Right)
    public void inorder(BinaryNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // Preorder Traversal (Root, Left, Right)
    public void preorder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal (Left, Right, Root)
    public void postorder(BinaryNode node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.levelOrder(); // 1 2 3 4 5

        System.out.print("Inorder: "); tree.inorder(tree.root); // 4 2 5 1 3
        System.out.print("\nPreorder: "); tree.preorder(tree.root); // 1 2 4 5 3
        System.out.print("\nPostorder: "); tree.postorder(tree.root); // 4 5 2 3 1
        System.out.println("");

        System.out.println(tree.search(3)); // true
        tree.delete(2);
        tree.levelOrder(); // 1 5 3 4
    }
}

