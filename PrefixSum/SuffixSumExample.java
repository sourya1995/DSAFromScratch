package PrefixSum;

import java.util.Arrays;

public class SuffixSumExample {
    public static int[] suffixSumArray(int[] nums) {
        int n = nums.length;
        int[] suffixSum = new int[n + 1]; // one spot more because last element is 0
        suffixSum[n] = 0;

        for (int i = n - 1; i >= 0; --i) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        return suffixSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] suffixSum = suffixSumArray(nums);
        // For demonstration, let's print the suffix sum array
        // The actual suffix sums for nums are at indices 0 to n-1
        // suffixSum[0] will be sum of all elements
        // suffixSum[1] will be sum of elements from index 1 to end, and so on.
        // suffixSum[n] will be 0.
        System.out.println(Arrays.toString(suffixSum));
    }
}
