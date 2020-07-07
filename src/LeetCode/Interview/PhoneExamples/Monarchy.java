package LeetCode.Interview.PhoneExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Monarchy implements MonarchyIF {
  class Person {
    public String name;
    public List<Person> children;
    public boolean isAlive;
    public Person (String name) {
      this.name = name;
      this.children = new ArrayList<>();
      this.isAlive = true;
    }
  }

  String king;
  HashMap<String, Person> personMap;

  public Monarchy() {
    this.personMap = new HashMap<>();
  }

  public Monarchy(String king) {
    this.personMap = new HashMap<>();
    this.king = king;
    Person kingPerson = new Person(king);
    this.personMap.put(king, kingPerson);
  }

  public void birth(String child, String parent) {
    Person childPerson = new Person(child);
    if(personMap.isEmpty()) {
      this.king = child;
    }
    personMap.put(child, childPerson);
    if(personMap.containsKey(parent)) {
      List<Person> olderChildren = personMap.get(parent).children;
      olderChildren.add(childPerson);
    } else {
      System.out.println(String.format("Parent %s does not exist for child %s", parent, child));
    }
  }

  public void death(String name) {
    if(!personMap.containsKey(name)) {
      System.out.println(String.format("Person %s does not exist, therefore it can't be dead", name));
    }

    personMap.get(name).isAlive = false;
  }

  public List<String> getOrderOfSuccession() {
    if(personMap.isEmpty()) {
      return new ArrayList<>();
    }
    List<String> succession = new ArrayList<>();

    Stack<Person> stack = new Stack();
    stack.push(personMap.get(king));

    while(!stack.isEmpty()) {
      Person current = stack.pop();
      if(current.isAlive) {
        succession.add(current.name);
      }
      for(int i = current.children.size() -1; i >= 0; i--) {
        stack.push(current.children.get(i));
      }
    }

    return succession;
  }
}

class TestMonarchy {
  public static void main(String[] args) {
    Monarchy monarchy = new Monarchy("king");
    monarchy.birth("a1", "king");
    monarchy.birth("a2", "king");
    monarchy.birth("b1", "a1");
    monarchy.birth("b2", "a1");
    monarchy.birth("c1","a2");
    monarchy.birth("c2","a2");
    monarchy.birth("d1","b1");
    monarchy.birth("d2","b1");
    monarchy.birth("d3","b2");

    monarchy.death("king");

    for(String royal : monarchy.getOrderOfSuccession()) {
      System.out.println(royal);
    }

  }
}
