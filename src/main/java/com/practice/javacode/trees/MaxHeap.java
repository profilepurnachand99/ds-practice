package com.practice.javacode.trees;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
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

    public int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[1]; // root
    }

    // Insert a new key
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap overflow");
            return;
        }

        heap[++size] = key; // place at next free spot
        int i = size;

        // Bubble up (swap with parent while larger)
        while (i > 1 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;

            i = parent(i);
        }
    }

    // Heapify down
    private void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l <= size && heap[l] > heap[largest])
            largest = l;

        if (r <= size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }

    // Remove and return the maximum element
    public int extractMax() {
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
        MaxHeap heap = new MaxHeap(20);
        heap.insert(10);
        heap.insert(40);
        heap.insert(20);
        heap.insert(5);
        heap.insert(60);
        heap.printHeap(); // structure may vary but root will be max // 60 40 20 5 10
        System.out.println(heap.extractMax()); // 60
        heap.printHeap(); // 40 10 20 5
        System.out.println(heap.getMax()); // next largest // 40
    }
}
