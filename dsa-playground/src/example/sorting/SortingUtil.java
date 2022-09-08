package example.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        public static void sort(int[] arr, int first, int last) {
            if (first < last) {
                int middle = first + (last - first) / 2;

                sort(arr, first, middle);
                sort(arr, middle + 1, last);

                mergeSortedArrays(arr, first, middle, last);
            }
        }

        private static void mergeSortedArrays(int[] arr, int first, int middle, int last) {
            int size = last - first + 1;
            List<Integer> sorted = new ArrayList<>(size);

            int left = first;
            int right = middle + 1;

            for (int i = 0; i < size; i++) {
                if (left > middle) {
                    sorted.add(arr[right++]);
                } else if (right > last) {
                    sorted.add(arr[left++]);
                }
                // compare with <= if we want to preserve order, i.e. stable algorithm
                else if (arr[left] <= arr[right]) {
                    sorted.add(arr[left++]);
                } else {
                    sorted.add(arr[right++]);
                }
            }

            for (int i = 0; i < size; i++) {
                arr[first++] = sorted.get(i);
            }
        }
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
