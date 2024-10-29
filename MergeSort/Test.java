package MergeSort;

public class Test {

    public static int[] generateArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }
        return numbers;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] smallData = generateArray(100);
        int[] mediumData = generateArray(2000);
        int[] largeData = generateArray(10000);

        long startSmall = System.currentTimeMillis();
        bubbleSort(smallData);
        long endSmall = System.currentTimeMillis();
        System.out.println("Time taken for small data: " + (endSmall - startSmall) + " ms");

        long startMedium = System.currentTimeMillis();
        bubbleSort(mediumData);
        long endMedium = System.currentTimeMillis();
        System.out.println("Time taken for medium data: " + (endMedium - startMedium) + " ms");

        long startLarge = System.currentTimeMillis();
        bubbleSort(largeData);
        long endLarge = System.currentTimeMillis();
        System.out.println("Time taken for large data: " + (endLarge - startLarge) + " ms");
    }
}