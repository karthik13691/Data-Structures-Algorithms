package QuickSort;
/**
 * The QuickSortSample class provides an implementation of the QuickSort algorithm for sorting an array of integers.
 * QuickSort has an average and best-case time complexity of O(n log n), but its worst-case time complexity is O(n^2).
 */
public class QuickSortSample {

    /**
     * Partitions the given array around a pivot element using the Lomuto partition scheme.
     * The last element of the array is chosen as the pivot.
     *
     * @param array the array to be partitioned
     * @param low   the starting index of the partition
     * @param high  the ending index of the partition
     * @return the index of the pivot element after partitioning
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Select the last element of the array as the pivot
        int i = low - 1; // index of the smaller element

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                swap(array, i, j);
            }
        }

        // Move the pivot to its correct position
        swap(array, i + 1, high);

        return (i + 1); // Return the partition index
    }

    /**
     * Swaps two elements in the given array.
     * Swapping is necessary in the partition step of the QuickSort algorithm to move elements
     * smaller than the pivot to the left side, and elements larger than the pivot to the right side.
     *
     * @param array the array containing the elements to swap
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Sorts the given array using the QuickSort algorithm.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the partition
     * @param high  the ending index of the partition
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition index
            int pivotIndex = partition(array, low, high);
            // Recursive sort the left sub array
            quickSort(array, low, pivotIndex - 1); // Before pivotIndex
            // Recursive sort the right sub array
            quickSort(array, pivotIndex + 1, high); // After pivotIndex
        }
    }

    /**
     * The main method to demonstrate the QuickSort algorithm.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Sample array
        int[] array = {300, 120, 100, 400, 350, 500, 600, 250, 375, 125};

        // Print the original array
        System.out.print("Original array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();

        // Print the sorted array and execution time
        System.out.print("Sorted array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Time taken: " + (end - start) + " milliseconds");
    }
}