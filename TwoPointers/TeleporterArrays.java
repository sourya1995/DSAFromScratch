package TwoPointers;

/* Leetcode 1537 - Get the Maximum Score */
public class TeleporterArrays {
    public int maxSum(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                // common element found
                // take the maximum path up to this point, and add the common element
                sum1 = Math.max(sum1, sum2) + nums1[i];
                sum2 = sum1;
                i++;
                j++;
            }

        }

        // process remaining elements in both arrays
        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }

        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }

        // return max of both paths
        return (int) (Math.max(sum1, sum2) % MOD);
    }
}
