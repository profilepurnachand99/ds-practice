package com.practice.javacode.trees;

public class BinaryTreeArray {
    int[] arr;
    int lastUsedIndex;

    // Constructor
    public BinaryTreeArray(int size) {
        arr = new int[size + 1];  // index 0 unused
        lastUsedIndex = 0;
    }

    // Check if tree is full
    public boolean isFull() {
        return lastUsedIndex == arr.length - 1;
    }

    // Insert node
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Tree is full");
            return;
        }
        arr[++lastUsedIndex] = value;
    }

    // Preorder traversal
    public void preorder(int index) {
        if (index > lastUsedIndex) return;

        System.out.print(arr[index] + " ");
        preorder(index * 2);
        preorder(index * 2 + 1);
    }

    // Inorder traversal
    public void inorder(int index) {
        if (index > lastUsedIndex) return;

        inorder(index * 2);
        System.out.print(arr[index] + " ");
        inorder(index * 2 + 1);
    }

    // Postorder traversal
    public void postorder(int index) {
        if (index > lastUsedIndex) return;

        postorder(index * 2);
        postorder(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    // Level-order traversal
    public void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Delete a node by value
    public void delete(int value) {
        int index = -1;

        // find the node
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Value not found");
            return;
        }

        // replace with deepest node
        arr[index] = arr[lastUsedIndex];
        lastUsedIndex--;
    }

    public static void main(String[] args) {
        BinaryTreeArray tree = new BinaryTreeArray(10);

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.print("Level Order: ");
        tree.levelOrder();   // 1 2 3 4 5

        System.out.print("Preorder: ");
        tree.preorder(1);    // 1 2 4 5 3

        System.out.print("\nInorder: ");
        tree.inorder(1);     // 4 2 5 1 3

        System.out.print("\nPostorder: ");
        tree.postorder(1);   // 4 5 2 3 1

        tree.delete(2);
        System.out.print("\nAfter delete: ");
        tree.levelOrder();   // 1 5 3 4
    }
}

