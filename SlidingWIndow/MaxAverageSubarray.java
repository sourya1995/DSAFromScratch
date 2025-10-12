package SlidingWIndow;

/* Leetcode 643 - Maximum Average Subarray I */
public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; ++i) {
            windowSum += nums[i];
        }

        int largest = windowSum;
        for (int right = k; right < nums.length; ++right) {
            int left = right - k;
            windowSum -= nums[left];
            windowSum += nums[right];
            largest = Math.max(windowSum, largest);
        }

        return (double) largest / k;
    }
}
