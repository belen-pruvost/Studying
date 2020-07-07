package LinkedLists;

public class Exercise2 {

  class Index {
    public int value = 0;
  }

  public LinkedListNode kthToLast(LinkedListNode head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  private LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
    if (head== null) {
      return null;
    }

    LinkedListNode node = kthToLast(head.next, k, idx);
    idx.value = idx.value + 1;
    if(idx.value == k) {
      return head;
    }
    return node;
  }
}
