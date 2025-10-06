package BinarySearch;

import java.util.List;

public class FirstTrueInABooleanSortedArray {
    public static int firstTrue(List<Boolean> arr){
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(arr.get(mid)){
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundaryIndex;
    }
}
