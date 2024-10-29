package MergeSort;

/**
 * This class implements the Merge Sort algorithm to sort an array of integers in ascending order.
 *
 * @author Your Name
 * @version 1.0
 */
public class MergeSortSample {

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private MergeSortSample() {
        // Utility class, no instances allowed
    }

    /**
     * Sorts the given array using the Merge Sort algorithm.
     *
     * @param numbers the array to be sorted
     * @param left    the starting index of the subarray to be sorted
     * @param right   the ending index of the subarray to be sorted
     */
    public static void mergeSort(int[] numbers, int left, int right) {
        if (numbers == null || numbers.length <= 1) {
            // Base case: array is null or has 0 or 1 element
            return;
        }

        if (left < right) {
            // Divide the array into two subarrays
            int middle = left + (right - left) / 2;

            // Recursively sort the two subarrays
            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);

            // Merge the two sorted subarrays
            merge(numbers, left, middle, right);
        }
    }

    /**
     * Merges two sorted subarrays of the given array into a single sorted subarray.
     *
     * @param numbers the array to be merged
     * @param left    the starting index of the left subarray
     * @param middle  the ending index of the left subarray (and starting index of the right subarray)
     * @param right   the ending index of the right subarray
     */
    private static void merge(int[] numbers, int left, int middle, int right) {
        int sizeOfLeftArray = middle - left + 1;
        int sizeOfRightArray = right - middle;

        // Create temporary arrays to hold the left and right subarrays
        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        // Copy data to temporary arrays
        for (int index = 0; index < sizeOfLeftArray; index++) {
            leftArray[index] = numbers[left + index];
        }
        for (int index = 0; index < sizeOfRightArray; index++) {
            rightArray[index] = numbers[middle + 1 + index];
        }

        // Merge the temporary arrays back into the original array
        int indexOfLeftArray = 0;
        int indexOfRightArray = 0;
        int indexOfMergedArray = left;

        // Merge the left and right subarrays in sorted order
        while (indexOfLeftArray < sizeOfLeftArray && indexOfRightArray < sizeOfRightArray) {
            if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray]) {
                numbers[indexOfMergedArray] = leftArray[indexOfLeftArray];
                indexOfLeftArray++;
            } else {
                numbers[indexOfMergedArray] = rightArray[indexOfRightArray];
                indexOfRightArray++;
            }
            indexOfMergedArray++;
        }

        // Copy the remaining elements from the left subarray, if any
        while (indexOfLeftArray < sizeOfLeftArray) {
            numbers[indexOfMergedArray] = leftArray[indexOfLeftArray];
            indexOfLeftArray++;
            indexOfMergedArray++;
        }

        // Copy the remaining elements from the right subarray, if any
        while (indexOfRightArray < sizeOfRightArray) {
            numbers[indexOfMergedArray] = rightArray[indexOfRightArray];
            indexOfRightArray++;
            indexOfMergedArray++;
        }
    }

    /**
     * The main method to test the Merge Sort algorithm.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] numbers = { 12, 11, 13, 10, 6, 33, 21, 10, 2, 0, 99, 23, 17, 47};
        System.out.println("Original array:");
        printArray(numbers);

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\nSorted array:");
        printArray(numbers);
    }

    /**
     * Prints the elements of the given array to the console.
     *
     * @param array the array to be printed
     */
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}