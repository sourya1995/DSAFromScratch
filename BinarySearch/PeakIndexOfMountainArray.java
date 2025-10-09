package BinarySearch;

/* Leetcode 852 - Peak Index of Mountain Array */
public class PeakIndexOfMountainArray {
    public int peakIndexInMountainArray(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int boundaryIndex = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid + 1]){
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return boundaryIndex;
    }
}
