package BinarySearch;

/* Leetcode 34 - Find First and Last Position of Element in Sorted Array
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target){
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int boundaryIndex = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                boundaryIndex = mid;
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return boundaryIndex;
    }

    private int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int boundaryIndex = -1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                boundaryIndex = mid;
                left = mid + 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return boundaryIndex;
    }
}
