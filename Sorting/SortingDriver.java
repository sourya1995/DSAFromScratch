package Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SortingDriver {
    private static final Logger logger = Logger.getLogger(SortingDriver.class.getName());

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        float[] floatArr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};

        // Insertion Sort
        testIntSort("Insertion Sort", arr.clone(), InsertionSort::insertionSort);

        // Selection Sort
        testIntSort("Selection Sort", arr.clone(), SelectionSort::selectionSort);

        // Bubble Sort
        testIntSort("Bubble Sort", arr.clone(), BubbleSort::bubbleSort);

        // Merge Sort
        testListSort("Merge Sort", arr);

        // Quick Sort
        testListSort("Quick Sort", arr);

        // Heap Sort
        testIntSort("Heap Sort", arr.clone(), HeapSort::heapSort);

        // Bucket Sort
        testFloatSort("Bucket Sort", floatArr.clone(), BucketSort::bucketSort);
        
        // Tree Sort
        testTreeSort("Tree Sort", arr.clone());
    }

    private static void testIntSort(String sortName, int[] arr, IntSort sortFunction) {
        try {
            logger.log(Level.INFO, "--- {0} ---", sortName);
            logger.log(Level.INFO, "Original array: {0}", Arrays.toString(arr));
            sortFunction.sort(arr);
            logger.log(Level.INFO, "Sorted array: {0}", Arrays.toString(arr));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during " + sortName, e);
        }
    }

    private static void testFloatSort(String sortName, float[] arr, FloatSort sortFunction) {
        try {
            logger.log(Level.INFO, "--- {0} ---", sortName);
            logger.log(Level.INFO, "Original array: {0}", Arrays.toString(arr));
            sortFunction.sort(arr);
            logger.log(Level.INFO, "Sorted array: {0}", Arrays.toString(arr));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during " + sortName, e);
        }
    }

    private static void testListSort(String sortName, int[] arr) {
        try {
            logger.log(Level.INFO, "--- {0} ---", sortName);
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            logger.log(Level.INFO, "Original list: {0}", list.toString());
            if (sortName.equals("Merge Sort")) {
                List<Integer> sortedList = MergeSort.sortList(list);
                logger.log(Level.INFO, "Sorted list: {0}", sortedList.toString());
            } else {
                List<Integer> sortedList = QuickSort.quickSort(list);
                logger.log(Level.INFO, "Sorted list: {0}", sortedList.toString());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during " + sortName, e);
        }
    }
    
    private static void testTreeSort(String sortName, int[] arr) {
        try {
            logger.log(Level.INFO, "--- {0} ---", sortName);
            logger.log(Level.INFO, "Original array: {0}", Arrays.toString(arr));
            TreeSort treeSort = new TreeSort();
            treeSort.treeSort(arr);
            logger.log(Level.INFO, "Sorted array: {0}", Arrays.toString(arr));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during " + sortName, e);
        }
    }

    @FunctionalInterface
    interface IntSort {
        void sort(int[] arr);
    }

    @FunctionalInterface
    interface FloatSort {
        void sort(float[] arr);
    }
}
