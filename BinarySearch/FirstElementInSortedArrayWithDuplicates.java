package BinarySearch;

import java.util.List;

public class FirstElementInSortedArrayWithDuplicates {
    public static int findFirstOccurrence(List<Integer> arr, int target){
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr.get(mid) == target){
                boundaryIndex = mid;
                right = mid - 1;
            } else if(arr.get(mid) < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return boundaryIndex;
    }
}
