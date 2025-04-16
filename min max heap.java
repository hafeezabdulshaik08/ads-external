import java.util.ArrayList;

public class MinHeap {
    // ArrayList to store heap elements
    ArrayList<Integer> heap = new ArrayList<>();

    // Insert a value into the heap
    public void insert(int value) {
        heap.add(value); // Add to the end
        heapifyUp(heap.size() - 1); // Restore heap
    }

    // Delete a specific value from the heap
    public void delete(int value) {
        int index = heap.indexOf(value);

        if (index == -1) {
            System.out.println("Value " + value + " not found in heap.");
            return;
        }

        int lastIndex = heap.size() - 1;

        // If deleting the last element, just remove it
        if (index == lastIndex) {
            heap.remove(lastIndex);
            return;
        }

        // Replace with last element and remove last
        heap.set(index, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Restore heap property
        heapifyDown(index);
        heapifyUp(index);
    }

    // Heapify up: fix heap from bottom to top
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    // Heapify down: fix heap from top to bottom
    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the contents of the heap
    public void display() {
        System.out.println("Heap contents: " + heap);
    }

    // Main method to test
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        // Insert elements into the heap
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(0);
        heap.insert(8);

        // Display initial heap
        heap.display();

        // Delete some elements
        heap.delete(15);
        heap.display();

        heap.delete(4);
        heap.display();

        heap.delete(100); // Value not in heap
    }
}


/// max heap
import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    // Insert a value into the max heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Delete any value from the heap
    public void delete(int value) {
        int index = heap.indexOf(value);

        if (index == -1) {
            System.out.println("Value " + value + " not found in heap.");
            return;
        }

        int lastIndex = heap.size() - 1;

        if (index == lastIndex) {
            heap.remove(lastIndex);
            return;
        }

        // Replace with last element and remove last
        heap.set(index, heap.get(lastIndex));
        heap.remove(lastIndex);

        // Restore heap property
        heapifyDown(index);
        heapifyUp(index);
    }

    // Heapify up for max heap (used after insert)
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    // Heapify down for max heap (used after delete)
    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Swap helper method
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the heap
    public void display() {
        System.out.println("Heap contents: " + heap);
    }

    // Main method to test the max heap
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        // Insert elements
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(0);
        heap.insert(8);

        // Display heap
        heap.display();

        // Delete a few elements
        heap.delete(15);
        heap.display();

        heap.delete(4);
        heap.display();

        heap.delete(100); // Not found
    }
}
