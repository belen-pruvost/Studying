package MorePractice;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
  class Node {
    int key;
    int value;
    int count;
    Node previous;
    Node next;

    public Node() {
    }

    public Node (int key, int value) {
      this.key = key;
      this.value = value;
      this.count = 1;
    }
  }

  class DLList {
    Node head, tail;
    int size;

    public DLList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.previous = head;
    }

    public void add(Node node) {
      head.next.previous = node;
      node.next = head.next;
      node.previous = head;
      head.next = node;
      size++;
    }

    public void remove(Node node) {
      node.previous.next = node.next;
      node.next.previous = node.previous;
      size--;
    }

    public Node removeLast() {
      if (size > 0) {
        Node node = tail.previous;
        remove(node);
        return node;
      }
      else return null;
    }
  }

  private int capacity;
  private int count;
  private int min;
  private Map<Integer, Node> map;
  private Map<Integer, DLList> countMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    this.map = new HashMap<>();
    this.countMap = new HashMap<>();
  }

  public int get(int key) {
    Node node = map.get(key);

    if (node == null) {
      return -1;
    }

    update(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }

    Node node = map.get(key);

    if (node == null) {
      node = new Node(key, value);
      map.put(key, node);

      if (count == capacity) {
        DLList lastList = countMap.get(min);
        map.remove(lastList.removeLast().key);
        count--;
      }

      count++;
      min = 1;
      DLList newList = countMap.getOrDefault(node.count, new DLList());
      newList.add(node);
      countMap.put(node.count, newList);
    } else {
      node.value = value;
      update(node);
    }
  }

  private void update(Node node) {
    DLList oldList = countMap.get(node.count);
    oldList.remove(node);
    if (node.count == min && oldList.size == 0) {
      min++;
    }
    node.count++;
    DLList newList = countMap.getOrDefault(node.count, new DLList());
    newList.add(node);
    countMap.put(node.count, newList);
  }
}

class TestLFUCache {
  public static void main(String[] args) {
    LFUCache lfuCache = new LFUCache(2);
    lfuCache.put(1,1);
    lfuCache.put(2,2);
    lfuCache.get(1);
    lfuCache.put(3,3);
    lfuCache.get(2);
    lfuCache.get(3);
    lfuCache.put(4,4);
    lfuCache.get(1);
    lfuCache.get(3);
    lfuCache.get(4);
  }
}