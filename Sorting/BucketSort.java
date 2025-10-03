package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        // Create n empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute input array values into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]); // Index in bucket
            if (bucketIndex >= n)
                bucketIndex = n - 1; // Edge case for value 1.0
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets using Insertion Sort
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }

    }
}
