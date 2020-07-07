package LeetCode.Interview.PhoneExamples;

import java.util.List;

public interface MonarchyIF {
  void birth(String child, String parent);
  void death(String name);
  List<String> getOrderOfSuccession();
}
