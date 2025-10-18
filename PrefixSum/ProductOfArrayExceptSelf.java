package PrefixSum;

/* Leetcode 238 - Product of Array Except Self */
public class ProductOfArrayExceptSelf {

    // naive solution
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n]; 
        
        left[0] = 1;
        right[n - 1] = 1;
        for(int i = 1; i < n; ++i){
            left[i] = left[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; --i){
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[n];
        for(int i = 0; i < n; ++i){
            result[i] = left[i] * right[i];
        }
        return result;


    }
    //faster solution
    public int[] productExceptSelfBetter(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; ++i){
            result[i] = 0;
        }

        int left = 1;
        for(int i = 0; i < n; ++i){
            result[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i = n - 1; i >= 0; --i){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

}
