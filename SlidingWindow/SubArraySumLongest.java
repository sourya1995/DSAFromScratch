package SlidingWindow;

public class SubArraySumLongest {
    public int longestSubarrayWithSumAtMost(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right]; // add the right element to window

            // shrink the window from the left until the sum is <= target
            while (sum > target) {
                sum -= nums[left]; // remove the left element from window
                left++; // shrink the window
            }

            // update the maximum length of the valid subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
