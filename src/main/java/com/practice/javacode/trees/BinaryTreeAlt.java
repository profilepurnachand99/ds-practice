package com.practice.javacode.trees;

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
public class BinaryTreeAlt {
    BinaryNode root;

    public BinaryTreeAlt() {
        root = null;
    }

    // INSERT (Level-order)
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
            } else if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    // SEARCH (Level-order)
    public boolean search(int value) {
        if (root == null) return false;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();

            if (current.value == value) return true;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return false;
    }

    // TRAVERSALS
    public void preorder(BinaryNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinaryNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void postorder(BinaryNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        if (root == null) return;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // DELETE DEEPEST NODE
    private void deleteDeepestNode() {
        if (root == null) return;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode parent = null;
        BinaryNode current = null;

        while (!queue.isEmpty()) {
            current = queue.remove();

            if (current.left != null) {
                parent = current;
                queue.add(current.left);
            }
            if (current.right != null) {
                parent = current;
                queue.add(current.right);
            }
        }

        // Remove deepest node
        if (parent != null) {
            if (parent.right == current) parent.right = null;
            else parent.left = null;
        } else {
            root = null;
        }
    }

    // DELETE NODE BY VALUE
    public void delete(int value) {
        if (root == null) return;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode target = null;

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();

            if (current.value == value) {
                target = current;
            }

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        if (target != null) {
            // Find deepest node
            BinaryNode deepest = getDeepestNode();
            target.value = deepest.value;
            deleteDeepestNode();
        }
    }

    // GET DEEPEST NODE
    private BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode current = null;

        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return current;
    }

    // DELETE ENTIRE TREE
    public void deleteTree() {
        root = null;
    }
}
