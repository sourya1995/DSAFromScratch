package BinarySearch;


/* Leetcode 540 - Single Element In Sorted Array */
public class SingleElementInASortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int result = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (toTheLeft(nums, mid)) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return nums[result];
        }

        private static boolean toTheLeft(int[] nums, int idx) {
            if (idx == nums.length - 1) {
                return true;
            } else if (idx % 2 == 1) {
                return nums[idx] != nums[idx - 1];
            } else {
                return nums[idx] != nums[idx + 1];
            }
        }
    }
}
