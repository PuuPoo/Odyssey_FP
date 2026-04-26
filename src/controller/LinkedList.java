package controller;

public class LinkedList {
    Node head;

    static class Node{
        String gmail;
        String patientName;
        byte patientAge;
        String patientSickness;
        String patientContact;
        int patientSeverity;
        Node next;

        Node(String gmail, String patientName, byte patientAge, String patientSickness, String patientContact, int patientSeverity){ //Constructor
            this.gmail = gmail;
            this.patientName = patientName;
            this.patientAge = patientAge;
            this.patientSickness = patientSickness;
            this.patientContact = patientContact;
            this.patientSeverity = patientSeverity;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, String gmail, String patientName, byte patientAge, String patientSickness, String patientContact, int severity){
        //Makes new node with the new data
        Node newNode = new Node(gmail, patientName, patientAge, patientSickness, patientContact, severity);

        //Checks if the linked list is empty or if the new data's patientSeverity is larger than the head
        if (list.head == null || severity > list.head.patientSeverity){
            newNode.next = list.head;
            list.head = newNode;
        }

        // Else traverse till finds where the data will be inputted
        // and insert the newNode there
        else{
            Node current = list.head;

            //keeps going until input data's patientSeverity is larger than the next following data's patientSeverity
            while(current.next != null && current.next.patientSeverity > severity){
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
            System.out.println(currNode.gmail + " " + currNode.patientName + " " + currNode.patientAge + " " + currNode.patientSickness + " " + currNode.patientContact + " " + currNode.patientSeverity);

            // Go to next node
            currNode = currNode.next;
        }
    }
}

