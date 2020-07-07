package LeetCode.Interview.LinkedLists;


public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    long result = getNumber(l1) + getNumber(l2);
    if(result == 0) {
      return new ListNode(0);
    }
    return parseNumber(result);
  }

  private long getNumber(ListNode n) {
    long number = 0;
    int i = 0;
    while(n != null) {
      number += n.val * Math.pow(10,i);
      i++;
      n = n.next;
    }

    return number;
  }

  private ListNode parseNumber(long n) {
    ListNode result = new ListNode(-1);
    ListNode head = result;
    while(n > 0) {
      ListNode current = new ListNode((int)n%10);
      head.next = current;
      head = head.next;
      n/=10;
    }
    return result.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class TestAddTwoNumbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(9);
    ListNode l4 = new ListNode(9);
    ListNode l5 = new ListNode(9);
    ListNode l6 = new ListNode(9);
    ListNode l7 = new ListNode(9);
    ListNode l8 = new ListNode(9);
    ListNode l9 = new ListNode(9);
    ListNode l10 = new ListNode(9);
    ListNode l11 = new ListNode(9);
    l10.next = l11;
    l9.next = l10;
    l8.next = l9;
    l7.next = l8;
    l6.next = l7;
    l5.next = l6;
    l4.next = l5;
    l3.next = l4;
    l2.next = l3;

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
    String j = "";
  }
}
