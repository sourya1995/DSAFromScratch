package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/* Leetcode 729 - My Calendar 1 */
public class MyCalendar1 {
    private final List<int[]> calendar;

    public MyCalendar1() {
        calendar = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime){
        int left = 0;
        int right = calendar.size() - 1;
        int index = calendar.size();

        while(left <= right){
            int mid = left + (right - left)/2;
            if(calendar.get(mid)[0] >= endTime){
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(index == calendar.size() || calendar.get(index)[0] >= endTime){
            calendar.add(index, new int[]{startTime, endTime});
            return false;
        } 

        calendar.add(index, new int[]{startTime, endTime});
        return true;
    }

    
}
