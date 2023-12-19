package dsa.practice;

public class ListNode {
    private int data;
    private static ListNode next;
    public ListNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        ListNode.next = next;
    }

    public ListNode getNext() {
        return next;
    }
}