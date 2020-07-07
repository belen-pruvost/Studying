package BitManipulation;

public class Explanation {
  public int repeatedArithmeticShift(int x, int count) {
    for (int i = 0; i< count; i++) {
      x >>=1;
    }
    return x;
  }

  public int repeatedLogicalShift(int x, int count) {
    for (int i = 0; i< count; i++) {
      x >>>=1;
    }
    return x;
  }

  public boolean getBit(int num, int i) {
    return ((num & (1 << i)) != 0);
  }
}
