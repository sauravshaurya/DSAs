package LinkedList;

class NodeD {
    int data;
    NodeD prev;
    NodeD next;

    public NodeD(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    NodeD head;
    NodeD tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void traverseForward(NodeD head) {
        NodeD current = head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void traverseBackwards(NodeD head) {
        NodeD current = head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.prev;
        }
    }

    public void insertAtBeginning(int data, NodeD head) {
        NodeD temp = new NodeD(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtEnd(NodeD head, int data) {
        NodeD temp = new NodeD(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void insertAtPosition(int data, NodeD head, int position) {
        NodeD temp = new NodeD(data);
        if (position == 1) {
            insertAtBeginning(data, head);
        }

        NodeD current = head;
        int currPos = 1;
        while (current != null && currPos < position) {
            current = current.next;
            currPos++;
        }
        if (current == null) {
            insertAtEnd(head, data);
        } else {
            temp.next = current;
            temp.prev = current.prev;
            current.prev.next = temp;
            current.prev = temp;
        }
    }

    public void deleteAtBeginning(NodeD head) {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        NodeD temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public void deleteAtEnd(NodeD head){
        if(tail == null){
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
        }

        NodeD temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public void deleteAtPosition(NodeD head, int pos){
        NodeD current = head;
        if(head == null){
            return;
        }
        if(pos == 1){
            deleteAtBeginning(head);
        }

        int count = 1;
        while(current!= null && count<pos){
            current = current.next;
            count++;
        }

        if(current == null){
            return;
        }

        if(current == tail){
            deleteAtEnd(head);
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }
}
