package ArraysAndStrings;

public class Exercise9 {
  public boolean isRotation(String s1, String s2) {
    int length = s1.length();
    if(length==0 || length!= s2.length()) {
      return false;
    }
    String s1s1 = s1 + s1;
    return isSubString(s1s1, s2);
  }

  private boolean isSubString(String s1, String s2) {
    return s1.contains(s2);
  }
}
