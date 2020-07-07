package LeetCode.Medium;

public class NumberOfIslands {
  /*
  * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
  * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
  * You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input:
    11110
    11010
    11000
    00000

    Output: 1
    *
    Example 2:
    Input:
    11000
    11000
    00100
    00011

    Output: 3
  *
  * */

  class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
      count = 0;
      int m = grid.length;
      int n = grid[0].length;

      parent = new int[m * n];
      rank = new int[m * n];

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            count++;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int getCount() {
      return count;
    }

    public int find(int i) {
      if(parent[i] != i) {
        parent[i] = find(parent[i]);
      }

      return parent[i];
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);

      if(rootX == rootY) {
        return;
      }

      if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
      count--;
    }
  }

  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    UnionFind uf = new UnionFind(grid);
    for(int r=0; r<rows; r++) {
      for(int c=0; c<cols; c++) {
        if(grid[r][c]=='1') {
          grid[r][c] = '0';
          if(r - 1 >= 0 && grid[r-1][c] == '1') {
            uf.union(r * cols + c, (r-1) * cols + c);
          }
          if(r + 1 < rows && grid[r+1][c] == '1') {
            uf.union(r * cols + c, (r+1) * cols + c);
          }
          if(c - 1 >= 0 && grid[r][c - 1] == '1') {
            uf.union(r * cols + c, r * cols + c - 1);
          }
          if(c + 1 < cols && grid[r][c + 1] == '1') {
            uf.union(r * cols + c, r * cols + c + 1);
          }
        }
      }
    }
    return uf.getCount();
  }
}

class TestingNumberOfIslands {
  public static void main(String[] args) {
    NumberOfIslands numberOfIslands = new NumberOfIslands();
    char[][] grid = new char[][] {{'1','1','1'}, {'0','1','0'}, {'1','0','0'}, {'1','0','1'}};
    System.out.println(numberOfIslands.numIslands(grid));
  }
}
