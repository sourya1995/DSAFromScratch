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

    // o(nLogN) approach using binary search
    public int minSubArrayLen2(int target, int[] nums) {
        int arrayLength = nums.length;
        int minLength = Integer.MAX_VALUE;

        int[] prefixSums = new int[arrayLength + 1];
        for (int i = 0; i < arrayLength; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // For each starting position, binary search for the ending position
        for (int startIndex = 0; startIndex < arrayLength; startIndex++) {
            int targetSum = target + prefixSums[startIndex]; // required sum to find
            int endIndex = binarySearch(prefixSums, targetSum);

            if (endIndex != -1) {
                minLength = Math.min(minLength, endIndex - startIndex);
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    private int binarySearch(int[] prefixSums, int targetSum) {
        int left = 0;
        int right = prefixSums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] >= targetSum) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
