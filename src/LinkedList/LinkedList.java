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

     Node removeNode(Node head, int pos) {
        Node temp = head;

        if(pos == 1) {
            head = temp.next;
            return head;
        }

        for(int i=1; temp != null & i<pos-1;i++) {
            temp = temp.next;
        }

        if(temp == null || temp.next == null) {
            return head;
        }

        temp.next = temp.next.next;

        return head;
    }

    Node removeNodeTwo(Node head, int pos) {
        Node temp = head;

        if(pos == 1) {
            head = temp.next;
            return head;
        }

        int count = 1;

        while(count < pos-1) {
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFromFront(2);
        list.insertFromFront(4);
        list.insertFromFront(9);
        list.insertFromFront(6);
        list.insertFromFront(0);
        list.insertFromFront(5);

        System.out.println("after inserting");
        list.printList();

        list.removeFirstNode();

        System.out.println("After removing first node");
        list.printList();

        Node head = list.head;

        System.out.println("After removing specific node");
        list.removeNodeTwo(head, 3);
        list.printList();
    }
}


