package PrefixSum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* here, we will return the FIRST matching subarray NOT the maximum length, which is asked in LC 325 */
public class SubarraySumEqualsK {

    public static List<Integer> findSubArrayWithSum(List<Integer> nums, int targetSum) {
        Map<Integer, Integer> prefixSumToPosition = new HashMap<>();
        prefixSumToPosition.put(0, 0);
        int currentSum = 0;

        for (int i = 0; i < nums.size(); ++i) {
            currentSum += nums.get(i);
            int complement = currentSum - targetSum; // complement is needed to compare the prefix sum with targetSum
            if (prefixSumToPosition.containsKey(complement)) {
                int startIndex = prefixSumToPosition.get(complement);
                int endIndex = i + 1;
                return nums.subList(startIndex, endIndex + 1);
            }

            prefixSumToPosition.putIfAbsent(currentSum, i + 1); // we use i + 1 because prefix sum is one ahead of the actual array
        }

        return null; // no subarray found
    }

}
