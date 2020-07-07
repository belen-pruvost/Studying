package BitManipulation;

public class Exercise3 {
  public int flipBit(int a) {
    if (~a == 0) {
      return Integer.BYTES * 8;
    }

    int currentLength = 0;
    int previousLength = 0;
    int maxLength = 1;
    while (a != 0) {
      if ((a & 1) == 1) { //if all 1s, then it is already the longest sequence
        currentLength++;
      } else if ((a & 1) == 0) { // Current bit is a 1
        //Update to 0 (if next bit is a 0) or currentLength (if next bit is a 1)
        previousLength = (a & 2) == 0 ? 0 : currentLength;
        currentLength = 0;
      }

      maxLength = Math.max(previousLength + currentLength + 1, maxLength);
      a >>>= 1;
    }
    return  maxLength;
  }
}
