package controller;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){ //Constructor
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data){
        //Makes new node with the new data
        Node newNode = new Node(data);

        //Checks if the linked list is empty or if the new data is larger than the head
        if (list.head == null || data > list.head.data){
            newNode.next = list.head;
            list.head = newNode;
        }

        // Else traverse till finds where the data will be inputted
        // and insert the newNode there
        else{
            Node current = list.head;

            //keeps going until input data is larger than the next following data
            while(current.next != null && current.next.data > data){
                current = current.next;
            }

            // Insert the data node
            newNode.next = current.next;
            current.next = newNode;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}

