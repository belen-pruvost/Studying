package MorePractice;

public class Exercise2 {
  public int solution(int A, int B) {
    // write your code in Java SE 8

    if(A == 0 || B == 0) {
      return 0;
    }

    Long product = Long.valueOf(A) * Long.valueOf(B);

    int count = 0;

    while (product > 0) {
      //if last bit is 1, it will add 1 to count
      //otherwise, it will add 0
      count += product & 1;
      product = product / 2;
    }
    return count;
  }

}

class TesCourseExercise2 {
  public static void main(String[] args) {
    Exercise2 exercise2 = new Exercise2();
    exercise2.solution(100000000, 100000000);
  }
}
