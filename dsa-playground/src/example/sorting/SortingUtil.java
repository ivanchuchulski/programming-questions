package example.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            insertionSort1(arr);
        }

        private void insertionSort1(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i;
                while (j >= 0 && j < arr.length && arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    j--;
                }
            }
        }

        private void insertionSort2(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    class QuickSort implements SortingUtil {

        @Override
        public void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private void quickSort(int[] arr, int first, int last) {
            if (first < last) {
                int pivotIndex = partition(arr, first, last);

                quickSort(arr, first, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, last);
            }
        }

        private int partition(int[] arr, int first, int last) {
            int pivot = arr[last];
            int border = first;

            for (int i = first; i < last; i++) {
                if (arr[i] <= pivot) {
                    swap(arr, i, border);
                    border++;
                }
            }

            swap(arr, border, last);

            return border;
        }
    }

    class MergeSort implements SortingUtil {

        @Override
        public void sort(int[] arr) {
            mergeSort(arr, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int first, int last) {
            if (first < last) {
                int middle = first + (last - first) / 2;

                mergeSort(arr, first, middle);
                mergeSort(arr, middle + 1, last);

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
                // compare with '<=' if we want to preserve order, i.e. stable algorithm
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
            int rangeStart = Integer.MAX_VALUE;
            int rangeEndInclusive = Integer.MIN_VALUE;

            for (int num : arr) {
                rangeStart = Math.min(num, rangeStart);
                rangeEndInclusive = Math.max(num, rangeEndInclusive);
            }

            countingSort(arr, rangeStart, rangeEndInclusive);
        }

        private void countingSort(int[] arr, int rangeStart, int rangeEndInclusive) {
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
