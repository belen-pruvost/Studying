package LinkedLists;

public class Exercise8 {
  public LinkedListNode findBeginningOfLoop(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    //Find meeting point. This will be LOOP_SIZE - k into the linked list
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }

    if (fast == null || fast.next == null) { //No loop
      return null;
    }

    //Move slow to head. Keep fast at meeting point. Each are at k steps from LoopStart
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}
