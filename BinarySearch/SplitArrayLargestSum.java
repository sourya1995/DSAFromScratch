package BinarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = -1;

        for(int num: nums){
            left = Math.max(left, num);
            right += num;
        }

        while(left <= right){
            int mid = left + (right - left)/2;

            if(canSplit(nums, k, mid)){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSum){
        int current = 0, count = 1;
        for(int n : nums){
            if(current + n > maxSum){
                count++;
                current = n;
                if(count > k) return false;
            } else {
                current += n;
            }
        }
        return true;
    }
}
