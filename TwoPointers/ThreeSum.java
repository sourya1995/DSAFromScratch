package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Leetcode 15 - 3Sum */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {
            // skip duplicate values
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            int leftIndex = firstIndex + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int sum = nums[firstIndex] + nums[leftIndex] + nums[rightIndex];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[firstIndex], nums[leftIndex], nums[rightIndex]));

                    // skip duplicate values for 2nd number
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }

                    // skip duplicate values for 3rd number
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }

                    leftIndex++;
                    rightIndex--;

                } else if (sum < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }

        return result;
    }
}
