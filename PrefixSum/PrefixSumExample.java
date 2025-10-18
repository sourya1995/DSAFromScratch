package PrefixSum;

import java.util.Arrays;

public class PrefixSumExample {
    public static int[] prefixSumArray(int[] nums) {
        int[] prefixSum = new int[nums.length + 1]; // one spot more because first element is 0
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        }
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] prefixSum = prefixSumArray(nums);
        System.out.println(Arrays.toString(prefixSum));
    }
}
