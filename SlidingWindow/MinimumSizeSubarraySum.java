package SlidingWindow;

/* Leetcode 209 - Minimum Size Subarray Sum */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right]; // add the right element to window

            // shrink the window from the left until the sum is < target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // update the minimum length
                sum -= nums[left]; // remove the left element from window
                left++; // shrink the window
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
