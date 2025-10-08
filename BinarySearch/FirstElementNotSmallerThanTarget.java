package BinarySearch;

import java.util.List;

/* Leetcode 34 - Find First and Last Position of Element in Sorted Array */
/* Leetcode 744 - Find Smallest Letter Greater Than Target */ 
public class FirstElementNotSmallerThanTarget {
    public static int firstNotSmaller(List<Integer> arr, int target){
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(arr.get(mid) >= target){
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundaryIndex;
    }
}