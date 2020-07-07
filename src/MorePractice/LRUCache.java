package MorePractice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node() {
    }

    public Node (int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private int count;
  private Node head;
  private Node tail;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;
    this.map = new HashMap<>();
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.previous = head;
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
    Node node = map.get(key);

    if (node == null) {
      node = new Node(key, value);
      map.put(key, node);
      add(node);
      count++;
    } else {
      node.value = value;
      update(node);
    }

    if (count > capacity) {
      Node toDelete = tail.previous;
      remove(toDelete);
      map.remove(toDelete.key);
      count--;
    }
  }

  private void update(Node node) {
    remove(node);
    add(node);
  }

  private void add(Node node) {
    Node after = head.next;
    head.next = node;
    node.previous = head;
    node.next = after;
    after.previous = node;
  }

  private void remove(Node node) {
    Node before = node.previous;
    Node after = node.next;
    before.next = after;
    after.previous = before;
  }
}

class TestLRUCache {
  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1,1);
    lruCache.put(2,2);
    lruCache.get(1);
    lruCache.put(3,3);
    lruCache.get(2);
    lruCache.put(4,4);
    lruCache.get(1);
    lruCache.get(3);
    lruCache.get(4);
  }
}