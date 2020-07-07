package RecursionAndDynamicProgramming;

import java.util.Stack;

public class Exercise6 {
  /*
   * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
   *  different sizes which can slide onto any tower.The puzzle starts with disks sorted
   *  in ascending order of size from top to bottom (i.e., each disk sits on top of an even
   *  larger one). You have the following constraints:
   *  (1) Only one disk can be moved at a time.
   *  (2) A disk is slid off the top of one tower onto the next tower.
   *  (3) A disk can only be placed on top of a larger disk.
   *  Write a program to move the disks from the first tower to the last using stacks.
   *
   * Solution:
   *  To move N disks from tower A to tower B:
   *  1. move top N -1 disks from tower A to tower C
   *  2. move N'th disk from tower A to tower B
   *  3. move top N-1 disks from tower C to tower B
   *
  * */

  class Tower {
    private Stack<Integer> disks;
    private int index;
    public Tower(int i) {
      index = i;
      disks = new Stack<>();
    }

    public int index() {
      return index;
    }

    public void add(int d) {
      if (!disks.isEmpty() && disks.peek() <= d) {
        System.out.println("Error placing disk " + d);
      } else {
        disks.push(d);
      }
    }

    public void moveTopTo(Tower t) {
      int top = disks.pop();
      t.add(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
      if (n>0) {
        moveDisks(n-1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n-1, destination, this);
      }
    }
  }

  void main(String[] args) {
    int n = 3;
    Tower[] towers = new Tower[n];

    for(int i = 0; i < n; i++) {
      towers[i] = new Tower(i);
    }

    for (int i = n-1; i >= 0; i--) {
      towers[0].add(i);
    }

    towers[0].moveDisks(n, towers[2], towers[1]);

  }
}
