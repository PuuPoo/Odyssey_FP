package controller;

public class BinaryHeap {
    // To store array of elements in the heap
    private Appointment[] heapArray;

    // max size of the heap
    private int capacity;

    // Current number of elements in the heap
    private int currentHeapSize;


    // Constructor
    public BinaryHeap(int n) {
        capacity = n;
        heapArray = new Appointment[capacity];
        currentHeapSize = 0;
    }

    //inserting into the heap
    public void insert(Appointment data) {
        if (currentHeapSize == capacity) {
            return; // Heap is full
        }

        // 1. Place at the end
        int index = currentHeapSize;
        heapArray[index] = data;
        currentHeapSize++;

        // 2. Bubble Up
        bubbleUp(index);
    }

    private void bubbleUp(int index) {
        //Calculate where the parent is located in the array
        int parent = (index - 1) / 2;

        //Loops until the root is hit (index 0) or the order is correct
        while (index > 0 && heapArray[index].getSeverity() > heapArray[parent].getSeverity()) {
            //swap the current element with its parent
            swap(index, parent);

            //update the index to follow the moved value
            index = parent;

            //recalculate the new parent position to keep moving up
            parent = (index - 1) / 2;
        }
    }

    public Appointment poll() {
        if (currentHeapSize == 0) {
            return null; //Check if heap is empty
        }

        Appointment root = heapArray[0];
        // Replace root with last element
        heapArray[0] = heapArray[currentHeapSize - 1]; //Puts the lowest value on top
        currentHeapSize--; //reduces the current heap size

        // Bubble Down
        bubbleDown(0); //Bubble down the lowest value to maintain order
        return root;
    }


    private void bubbleDown(int index) {
        int largest = index;        //Assumes the current is the largest
        int left = 2 * index + 1;   //Identify the left child
        int right = 2 * index + 2;  //Identify the right child

        //Check if the left child exist and if it's greater than the parent
        if (left < currentHeapSize && heapArray[left].getSeverity() > heapArray[largest].getSeverity()) {
            largest = left;
        }

        //Check if the right child exists and is greater than the current largest
        if (right < currentHeapSize && heapArray[right].getSeverity() > heapArray[largest].getSeverity()){
            largest = right;
        }

        //If the largest is not the current node
        if (largest != index) {
            swap(index, largest);       // Swap to maintain Max-Heap order
            bubbleDown(largest);        // Recursively repeat for the next level
        }
    }

    //Bubble swap
    private void swap(int i, int j) {
        Appointment temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }



    //Printing the binary heap structure (debugging purposes)
    public void printHeapArray() {
        System.out.println("Heap Array:" );
        for (int i = 0; i < currentHeapSize; i++) {
            System.out.println("(" + heapArray[i].getSeverity() + ":" + heapArray[i].getPatient() + ") ");
        }
    }


}
