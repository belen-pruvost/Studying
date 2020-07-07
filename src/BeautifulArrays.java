import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BeautifulArrays {
//  *
//      * Complete the 'beautifulSubarrays' function below.
//      *
//      * The function is expected to return a LONG_INTEGER.
//      * The function accepts following parameters:
//      *  1. INTEGER_ARRAY arr
//     *  2. INTEGER numOdds
//     */

//  static Set<List<Integer>> result = new HashSet<>();

  public static long beautifulSubarrays2(List<Integer> arr, int numOdds) {
    // Write your code here
    int size = arr.remove(0);
    int count = 0;
    int currentOdds = 0;
    int left = 0;
    int right = 0;
    boolean rightMovement = true;
    while(right < size && left <= right) {
      if(rightMovement && arr.get(right) % 2 == 1) {
        currentOdds++;
      }
      if(currentOdds == numOdds) {
        count++;
        if(arr.get(left) % 2 == 1) {
          currentOdds--;
        }
        left++;
        rightMovement = false;
      } else {
        right++;
        rightMovement = true;
      }
    }

    return count;
  }

  public static long beautifulSubarrays(List<Integer> arr, int numOdds) {
    // Write your code here
    int size = arr.remove(0);
    long total = 0;
//    Set<int[]> result = new HashSet<>();
    for(int i = 0; i < size; i++) {
      int currentOdds = 0;
      int j = i;
      while(j < size && currentOdds <= numOdds) {
        if(arr.get(j) % 2 == 1) {
          currentOdds++;
        }
        if(currentOdds == numOdds) {
//          result.add(new int[]{i, j});
          total++;
        }
        j++;
      }
    }

    return total;
  }

//  private static void backtrack(int totalOdds, int index, int totalSize,
//                                List<Integer> current,
//                                int numOdds, List<Integer> arr){
////    if(index >= totalSize) {
////      return;
////    }
//    if(index == totalSize - 1 && totalOdds == numOdds) {
//      result.add(current);
//      return;
//    }
//    if(totalOdds == numOdds) {
//      while(arr.get(index) % 2 == 1 && index < totalSize) {
//        index++;
//      }
//
//    }
//
//    int currentNumber = arr.get(index);
//    boolean isOdd = currentNumber % 2 == 1;
//    if(isOdd) {
//      totalOdds++;
//    }
//    current.add(currentNumber);
//    backtrack(totalOdds, index + 1, totalSize, current, numOdds, arr);
//  }
}

class TestBeautifulArrays {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(2);
    list.add(5);
    list.add(4);
    list.add(9);
    System.out.println(BeautifulArrays.beautifulSubarrays(list, 1));
  }
}

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int numOdds = Integer.parseInt(bufferedReader.readLine().trim());

    long result = BeautifulArrays.beautifulSubarrays(arr, numOdds);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
