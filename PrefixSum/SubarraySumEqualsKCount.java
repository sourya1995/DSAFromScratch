package PrefixSum;

import java.util.HashMap;
import java.util.List;

public class SubarraySumEqualsKCount {
    public static int subarraySumTotal(List<Integer> nums, int targetSum) {
        HashMap<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.size(); ++i) {
            currentSum += nums.get(i);
            int complement = currentSum - targetSum;
            if (prefixSumToCount.containsKey(complement)) {
                count += prefixSumToCount.get(complement);
            }

            if (prefixSumToCount.containsKey(currentSum)) {
                prefixSumToCount.put(currentSum, prefixSumToCount.get(currentSum) + 1);
            } else {
                prefixSumToCount.put(currentSum, 1);
            }
        }

        return count;

    }
}
