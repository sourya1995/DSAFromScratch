package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumToPosition = new HashMap<>();
        prefixSumToPosition.put(0, 0);
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; ++i) {
            currentSum += nums[i];
            int complement = currentSum - k;
            if (prefixSumToPosition.containsKey(complement)) {
                int startIndex = prefixSumToPosition.get(complement);
                int endIndex = i + 1;
                maxLength = Math.max(maxLength, endIndex - startIndex);
            }

            prefixSumToPosition.putIfAbsent(currentSum, i + 1);
        }

        return maxLength;
    }
}
