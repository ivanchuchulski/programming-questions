package example;

public interface SortingUtil {

    void sort(int[] arr);

    class SelectionSort implements SortingUtil {

        @Override
        public void sort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int minIndex = i;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }

                if (i != minIndex) {
                    swap(arr, i, minIndex);
                }
            }
        }
    }

    class BubbleSort implements SortingUtil {
        @Override
        public void sort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean subArrayIsSorted = true;

                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j + 1] < arr[j]) {
                        subArrayIsSorted = false;
                        swap(arr, j, j + 1);
                    }
                }

                if (subArrayIsSorted) {
                    System.out.printf("sub arr from %d onwards is sorted%n", i);
                    break;
                }
            }
        }
    }

    class InsertionSort implements SortingUtil {
        @Override
        public void sort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i;
                while (j >= 0 && j < arr.length && arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    j--;
                }
            }
            // equivalently
            //     for (int i = 1; i < arr.length; i++) {
            //         for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
            //             swap(arr, j, j - 1);
            //         }
            //     }
        }
    }

    default void swap(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }
}
