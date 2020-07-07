package MorePractice.LeetCode.Arrays;

import java.util.*;

public class BrowserHistory {
  List<String> history = new ArrayList<>();
  int count = 0;
  public BrowserHistory(String homepage) {
    System.out.println("Home Page: " + homepage);
    history.add(homepage);
  }

  public void visit(String url) {
    System.out.println("URL:"+ url);
    System.out.println("Current count:"+ count + " - Future count: " + (count + 1));
    System.out.println("History size: " + history.size());
    count++;
    int index = history.size() - 1;
    while(index >= count) {
      history.remove(index--);
    }

    history.add(count, url);
    System.out.println("New Url: " + url + " - count: " + count + " - history size: " + history.size());
  }

  public String back(int steps) {
    count = Math.max(count - steps, 0);
    System.out.println("Back steps " + steps + " - count: " + count + " - url: " + history.get(count));
    return history.get(count);
  }

  public String forward(int steps) {
    count = Math.min(history.size() - 1, count + steps);
    System.out.println("Forward steps " + steps + " - count: " + count + " - url: " + history.get(count));
    return history.get(count);
  }
}

class TestBrowserHistory {
  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory("esgriv.com");
    browserHistory.visit("cgrt.com");
    browserHistory.visit("tip.com");
    browserHistory.back(9);
    browserHistory.visit("kttzxgh.com");
    browserHistory.forward(7);
    browserHistory.visit("crqje.com");
    browserHistory.visit("iybch.com");
    browserHistory.forward(5);
    browserHistory.visit("uun.com");
    browserHistory.back(10);
    browserHistory.visit("hci.com");
    browserHistory.visit("whula.com");
    browserHistory.forward(10);
  }
}
