package LinkedLists;

public class LinkedListNode {
  public LinkedListNode next;
  public int data;

  public LinkedListNode(LinkedListNode n, int d) {
    data = d;
    next = n;
  }

  public LinkedListNode(int d) {
    data = d;
  }
}
