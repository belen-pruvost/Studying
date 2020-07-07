package RecursionAndDynamicProgramming;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Exercise2 {
  /*
  *Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
  * The robot can only move in two directions, right and down, but certain cells are "off limit" such that the robot cannot step on them.
  * Design an algorithm to find a path for the robot from the top left to the bottom right.
  * */

  static ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) {
      return null;
    }

    ArrayList<Point> path = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if(getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }

    return null;
  }

  static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
    //If out of bounds or not available, return
    if(col < 0 || row < 0 || !maze[row][col]) {
      return false;
    }

    Point p = new Point(row, col);
    //If we have already visited this cell, return
    if(failedPoints.contains(p)) {
      return false;
    }

    boolean isAtOrigin = (row == 0) && (col == 0);

    //If there is a path from start to my current location, add my location
    if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }

    failedPoints.add(p); //Cache results
    return false;
  }

  public static void main(String[] args) {
    boolean[][] maze = new boolean[2][2];
    Arrays.fill(maze[0], true);
    Arrays.fill(maze[1], true);
    maze[1][0] = false;
    getPath(maze);
  }
}
