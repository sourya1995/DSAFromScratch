package BinarySearch;

/* Leetcode 153 - Find Minimum in Rotated Sorted Array */ 

public class FindMinimumInARotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[result]){
                result = mid;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[result];
    }// this is a meh solution

    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    } // this is a better solution

} 
