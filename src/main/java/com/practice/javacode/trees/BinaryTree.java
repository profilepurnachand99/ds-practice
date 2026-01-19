package com.practice.javacode.trees;

import java.util.LinkedList;
import java.util.Queue;

// Binary Tree class
public class BinaryTree {
    BTNode root;

    // Level-order traversal
    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BTNode current = queue.remove();
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

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BTNode current = queue.remove();

            if (current.value == value)
                return true;

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
        return false;
    }

    // Search a value
    public boolean searchRecursive(int value) {
        return searchRec(root, value);
    }

    // Recursive search in a general binary tree
    private boolean searchRec(BTNode root, int value) {
        // Base case: empty tree
        if (root == null) return false;
        // If current node matches
        if (root.value == value) return true;

        // Recursively search left and right subtrees
        return searchRec(root.left, value) || searchRec(root.right, value);
    }

    // Insert node in level order
    public void insert(int value) {
        BTNode newNode = new BTNode(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BTNode current = queue.remove();

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

    // Delete a node by replacing it with the deepest node
    public void delete(int value) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.value == value)
                root = null;
            return;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        BTNode target = null;
        BTNode current = null;
        BTNode parentOfDeepest = null;

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

        //current will be the deepest node after level order traversal
        if (target != null) {
            target.value = current.value; // replace with deepest node value
            deleteDeepest(parentOfDeepest, current);
        }
        // (or) use below block
        /*if (target != null) {
            // Find deepest node
            BTNode deepest = getDeepestNode();
            target.value = deepest.value;
            deleteDeepestNode();
        }*/
    }

    // Helper to delete deepest node
    private void deleteDeepest(BTNode parentOfDeepest, BTNode deepest) {
        if (parentOfDeepest == null) {
            root = null;
            return;
        }

        if (parentOfDeepest.right == deepest)
            parentOfDeepest.right = null;
        else
            parentOfDeepest.left = null;
    }

    private void deleteDeepestFromRoot(BTNode root, BTNode deepest) {
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode current = q.remove();

            if (current.left != null) {
                if (current.left == deepest) {
                    current.left = null;
                    return;
                }
                q.add(current.left);
            }

            if (current.right != null) {
                if (current.right == deepest) {
                    current.right = null;
                    return;
                }
                q.add(current.right);
            }
        }
    }

    // Inorder Traversal (Left, Root, Right)
    public void inorder(BTNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // Preorder Traversal (Root, Left, Right)
    public void preorder(BTNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal (Left, Right, Root)
    public void postorder(BTNode node) {
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

        System.out.print("Inorder: ");
        tree.inorder(tree.root); // 4 2 5 1 3
        System.out.print("\nPreorder: ");
        tree.preorder(tree.root); // 1 2 4 5 3
        System.out.print("\nPostorder: ");
        tree.postorder(tree.root); // 4 5 2 3 1
        System.out.println();

        System.out.println(tree.search(3)); // true
        tree.delete(2);
        tree.levelOrder(); // 1 5 3 4
    }

    // GET DEEPEST NODE
    private BTNode getDeepestNode() {
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        BTNode current = null;

        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return current;
    }

    // DELETE DEEPEST NODE
    private void deleteDeepestNode() {
        if (root == null) return;

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);

        BTNode parent = null;
        BTNode current = null;

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
    } //method end
}