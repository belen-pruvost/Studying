package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Codility {
  Set<Integer> positiveNumbers = new HashSet<>();

  public int solution(int[] A) {
    // write your code in Java SE 8
    setPositiveNumbers(A);
    return getSmallestPositiveNumber();
  }

  private void setPositiveNumbers(int[] array) {
    Arrays
        .stream(array)
        .filter(i -> i > 0)
        .forEach(i -> positiveNumbers.add(i));
  }

  private int getSmallestPositiveNumber() {
    for(int i = 1; i <= positiveNumbers.size(); i++) {
      if(!positiveNumbers.contains(i)) {
        return i;
      }
    }

    return positiveNumbers.size() + 1;
  }
}
