package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SnapShotArray {
     private List<List<int[]>> histories;
    private int snapId;

    public SnapShotArray(int length) {
        histories = new ArrayList<>(length);
        for(int i=0; i < length; i++){
            List<int[]> history = new ArrayList<>();
            history.add(new int[]{-1, 0});
            histories.add(history);
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
        histories.get(index).add(new int[]{snapId, val});
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> history = histories.get(index);
        int left = 0;
        int right = history.size() - 1;
        int position = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(history.get(mid)[0] <= snap_id){
                position = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return history.get(position)[1];
    }
}
