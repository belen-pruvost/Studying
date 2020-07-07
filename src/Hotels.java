import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Hotels {



  public static List<Integer> awardTopKHotels(String positiveKeywords,
                                              String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
    class Hotel {
      public int id;
      public int points;
    }
    // Write your code here

    String[] positiveWords = positiveKeywords.split(" ");
    String[] negativeWords = negativeKeywords.split(" ");
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Hotel> maxHeap = new PriorityQueue<Hotel>((a, b) -> b.points - a.points);

    HashMap<Integer, Integer> hotels = new HashMap();
    for(int i =0; i < hotelIds.size(); i++) {
      int hotelId = hotelIds.get(i);
      String review = reviews.get(i);
      int currentScore = 0;
      for(String positiveWord : positiveWords) {
        if(review.contains(positiveWord)) {
          currentScore +=3;
        }
      }
      for(String negativeWord : negativeWords) {
        if(review.contains(negativeWord)) {
          currentScore--;
        }
      }

      hotels.put(hotelId, hotels.getOrDefault(hotelId, 0) + currentScore);
    }

    for(int i : hotels.keySet()) {
      Hotel h = new Hotel();
      h.id = i;
      h.points = hotels.get(i);
      maxHeap.add(h);
    }

    for(int i =0; i <k && !maxHeap.isEmpty(); i++) {
      result.add(maxHeap.remove().id);
    }

    Collections.sort(result);
    return result;
  }
}
