package LinkedLists;

public class Exercise5 {
  //Follow up exercise

  class PartialSum {
    public LinkedListNode sum = null;
    public int carry = 0;
  }

  int length(LinkedListNode l) {
    int count = 0;
    while(l!=null) {
      count++;
      l = l.next;
    }
    return count;
  }

  LinkedListNode insertBefore(LinkedListNode l, int data) {
    LinkedListNode node = new LinkedListNode(data);
    if (l!=null) {
      node.next = l;
    }
    return node;
  }

  LinkedListNode padList(LinkedListNode l, int padding) {
    LinkedListNode head = l;
    for (int i=0; i< padding; i++) {
      head = insertBefore(head, 0);
    }
    return head;
  }

  PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
    if(l1== null && l2==null) {
      return new PartialSum();
    }
    PartialSum sum = addListHelper(l1.next, l2.next);
    int val = sum.carry + l1.data + l2.data;
    LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
    sum.sum = fullResult;
    sum.carry = val / 10;
    return sum;
  }

  public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
    int len1 = length(l1);
    int len2 = length(l2);
    if(len1 < len2) {
      l1 = padList(l1, len2 - len1);
    } else {
      l2 = padList(l2, len1 - len2);
    }
    PartialSum sum = addListHelper(l1, l2);
    if (sum.carry == 0) {
      return sum.sum;
    }
    LinkedListNode result = insertBefore(sum.sum, sum.carry);
    return result;
  }
}
