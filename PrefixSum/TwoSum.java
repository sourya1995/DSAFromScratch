package PrefixSum;

import java.util.Arrays;
import java.util.HashMap;

/* Leetcode 1 - Two Sum */
public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; //we are returning the indices of the items that add up to target
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
