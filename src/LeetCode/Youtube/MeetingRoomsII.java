package LeetCode.Youtube;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  /*
  * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    Example 1:

    Input: [[0, 30],[5, 10],[15, 20]]
    Output: 2
    Example 2:

    Input: [[7,10],[2,4]]
    Output: 1
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
  */
  public int minMeetingRooms(int[][] intervals) {
    if(intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    minHeap.add(intervals[0]);
    for(int i=1; i<intervals.length; i++) {
      int[] current = intervals[i];
      int[] earliest = minHeap.remove();
      if(current[0] >= earliest[1]) {
        earliest[1] = current[1];
      } else {
        minHeap.add(current);
      }
      minHeap.add(earliest);
    }
    return minHeap.size();
  }
}

class TestMeetingRoomsII {
  public static void main(String[] args) {
    int[][] intervals = new int[][]{{0, 30}, {5, 10},{15, 20}};
    int[][] intervals2 = new int[][]{{7, 10}, {2,4}};

    MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
    System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    System.out.println(meetingRoomsII.minMeetingRooms(intervals2));
  }
}
