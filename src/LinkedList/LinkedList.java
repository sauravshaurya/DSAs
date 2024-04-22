package LinkedList;


public class LinkedList extends Node{

    Node head;

    void insertFromFront(int data) {

        Node ins = new Node();
        ins.data = data;

        ins.next = head;
        head = ins;
    }

    void removeFirstNode() {
        if(head == null) {
            return;
        }
        Node temp = head;
        head = head.next;
    }

    void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFromFront(2);
        list.insertFromFront(4);
        list.insertFromFront(9);
        list.insertFromFront(6);
        list.insertFromFront(0);
        list.insertFromFront(5);

        System.out.println("aafter inserting");
        list.printList();

        list.removeFirstNode();

        System.out.println("After removing first node");
        list.printList();
    }
}


