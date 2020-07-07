package RecursionAndDynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Exercise4 {
  /*
  Power Set: Write a method to return all subsets of a set
  * */
  static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSubsets;
    if(set.size() == index) { //Base case - add empty set
      allSubsets = new ArrayList<ArrayList<Integer>>();
      allSubsets.add(new ArrayList<Integer>()); //Empty set
    } else {
      allSubsets = getSubsets(set, index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

      for(ArrayList<Integer> subset : allSubsets) {
        ArrayList<Integer> newSubset = new ArrayList<Integer>();
        newSubset.addAll(subset);
        newSubset.add(item);
        moreSubsets.add(newSubset);
      }
      allSubsets.addAll(moreSubsets);
    }

    return allSubsets;
  }

  static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
    ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
    int max = 1 << set.size(); // 2 ^ n
    for(int k=0; k < max; k++) {
      ArrayList<Integer> subset = convertIntToSet(k, set);
      allSubsets.add(subset);
    }
    return allSubsets;
  }

  static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
    ArrayList<Integer> subset = new ArrayList<>();
    int index=0;
    for(int k = x; k > 0; k >>=1) {
      if((k&1) == 1) {
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }

  public static void main(String[] args) {
//    ArrayList<ArrayList<Integer>> result0;
//    ArrayList<Integer> set0 = new ArrayList<>();
//    result0 = getSubsets(set0, 0);

//    ArrayList<ArrayList<Integer>> result1;
//    ArrayList<Integer> set1 = new ArrayList<>();
//    set1.add(1);
//    result1 = getSubsets(set1, 0);

    ArrayList<ArrayList<Integer>> result2;
    ArrayList<Integer> set2 = new ArrayList<>();
    set2.add(1);
    set2.add(2);
    result2 = getSubsets(set2, 0);
//
//    ArrayList<ArrayList<Integer>> result3;
//    ArrayList<Integer> set3 = new ArrayList<>();
//    set3.add(1);
//    set3.add(2);
//    set3.add(3);
//    result3 = getSubsets(set3, 0);
//
//    ArrayList<ArrayList<Integer>> result4;
//    ArrayList<Integer> set4 = new ArrayList<>();
//    set4.add(1);
//    set4.add(2);
//    set4.add(3);
//    set4.add(4);
//    result4 = getSubsets(set4,0);

    String j = "";

  }
}
