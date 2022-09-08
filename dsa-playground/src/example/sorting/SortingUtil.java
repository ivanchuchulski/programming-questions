package example.sorting;

import java.util.HashMap;
import java.util.Map;

public interface SortingUtil {

    void sort(int[] arr);

    default void sort(int[] arr, int rangeStart, int rangeEndInclusive) {
        throw new UnsupportedOperationException();
    }

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

    class QuickSort {

    }

    class MergeSort {
    }

    class CountingSort implements SortingUtil {

        @Override
        public void sort(int[] arr) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void sort(int[] arr, int rangeStart, int rangeEndInclusive) {
            int rangeSize = Math.abs(rangeEndInclusive - rangeStart) + 1;
            Map<Integer, Integer> elements = new HashMap<>(rangeSize);

            for (int num : arr) {
                Integer count = elements.getOrDefault(num, 0);
                elements.put(num, count + 1);
            }

            int j = 0;
            for (int i = rangeStart; i <= rangeEndInclusive; i++) {
                Integer count = elements.get(i);
                for (int times = 0; times < count; times++) {
                    arr[j++] = i;
                }
            }
        }
    }

    default void swap(int[] arr, int leftIndex, int rightIndex) {
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }
}
