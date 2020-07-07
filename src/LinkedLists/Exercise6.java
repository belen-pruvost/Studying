package LinkedLists;

public class Exercise6 {
  //Recursive Approach

  class Result {
    public LinkedListNode node ;
    public boolean result;

    public Result(LinkedListNode node, boolean result) {
      this.node = node;
      this.result = result;
    }
  }

  public boolean isPalindrome(LinkedListNode head) {
    int length = length(head);
    Result p = isPalindromeRecurse(head, length);
    return p.result;
  }

  int length(LinkedListNode l) {
    int count = 0;
    while(l!=null) {
      count++;
      l = l.next;
    }
    return count;
  }

  Result isPalindromeRecurse(LinkedListNode head, int length) {
    if(head == null || length <= 0) {
      return new Result(head, true);
    }
    if(length == 1) {//Odd elements
      return new Result(head.next, true);
    }
    Result res = isPalindromeRecurse(head.next, length - 2);
    if (!res.result || res.node == null) {
      return res;
    }
    res.result = head.data == res.node.data;
    res.node = res.node.next;
    return res;
  }
}
