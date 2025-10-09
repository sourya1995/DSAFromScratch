package BinarySearch;

/* Leetcode 162 - Find Peak Element */
public class FindPeakElement {
     public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //int boundaryIndex = -1;
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid+1]){
                //boundaryIndex = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

