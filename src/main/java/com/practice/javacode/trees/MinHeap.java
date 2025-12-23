package com.practice.javacode.trees;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity + 1]; // index 0 unused
        size = 0;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[1]; // root at index 1
    }

    // Insert a new key
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap overflow");
            return;
        }

        heap[++size] = key; // place at next free spot
        int i = size;

        // Bubble up
        while (i > 1 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;

            i = parent(i);
        }
    }

    // Heapify down
    private void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l <= size && heap[l] < heap[smallest])
            smallest = l;

        if (r <= size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            heapify(smallest);
        }
    }

    // Remove and return the minimum element
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int root = heap[1];
        heap[1] = heap[size];
        size--;

        heapify(1);

        return root;
    }

    // Print heap
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(3);
        heap.insert(8);
        heap.printHeap(); // 3 5 20 10 8
        // prints heap starting at index 1
        System.out.println(heap.extractMin()); // 3
        heap.printHeap(); // 5 8 20 10
        System.out.println(heap.getMin()); // 5
    }
}