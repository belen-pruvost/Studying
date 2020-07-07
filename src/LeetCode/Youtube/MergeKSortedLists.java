package LeetCode.Youtube;

import java.util.PriorityQueue;

public class MergeKSortedLists {
  /*
  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
  Example:

  Input:
  [
    1->4->5,
    1->3->4,
    2->6
  ]
  Output: 1->1->2->3->4->4->5->6
  */

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(ListNode head : lists) {
      while(head != null) {
        minHeap.add(head.val);
        head = head.next;
      }
    }
    ListNode result = new ListNode(-1);
    ListNode head = result;
    while(!minHeap.isEmpty()) {
      head.next = new ListNode(minHeap.remove());
      head = head.next;
    }
    return result.next;
  }
}

class TestMergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
  }
}
