package controller;

public class LinkedList {
    Node head;

    static class Node{
        String gmail;
        String patient;
        int severity;
        Node next;

        Node(String gmail, String patient, int severity){ //Constructor
            this.gmail = gmail;
            this.patient = patient;
            this.severity = severity;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, String gmail, String patient, int severity){
        //Makes new node with the new data
        Node newNode = new Node(gmail, patient, severity);

        //Checks if the linked list is empty or if the new data's severity is larger than the head
        if (list.head == null || severity > list.head.severity){
            newNode.next = list.head;
            list.head = newNode;
        }

        // Else traverse till finds where the data will be inputted
        // and insert the newNode there
        else{
            Node current = list.head;

            //keeps going until input data's severity is larger than the next following data's severity
            while(current.next != null && current.next.severity > severity){
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
            System.out.println(currNode.gmail + " " + currNode.patient + " " + currNode.severity);

            // Go to next node
            currNode = currNode.next;
        }
    }
}

