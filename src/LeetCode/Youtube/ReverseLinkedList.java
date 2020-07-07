package LeetCode.Youtube;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class ReverseLinkedList {
  /*
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
    Follow up:

    A linked list can be reversed either iteratively or recursively. Could you implement both?
  * */

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  public ListNode reverseListRecursive(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}

class TestReverseLinkedList{
  public static void main (String[] args) {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    ListNode fifth = new ListNode(5);
    first.next = second;
    second.next = third;
//    third.next = fourth;
//    fourth.next = fifth;
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//    reverseLinkedList.reverseList(first);
    reverseLinkedList.reverseListRecursive(first);
  }
}
