package example.searching;

public interface SearchingUtil {
    public static int NOT_FOUND_CODE = -1;

    int search(int[] arr, int element);

    class LinearSearch implements SearchingUtil {

        @Override
        public int search(int[] arr, int element) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == element) {
                    return i;
                }
            }

            return NOT_FOUND_CODE;
        }

    }

    class BinarySearch implements SearchingUtil {

        @Override
        public int search(int[] arr, int element) {
            return helper(arr, 0, arr.length - 1, element);
        }

        private int helper(int[] arr, int first, int last, int element) {
            if (first > last) {
                return NOT_FOUND_CODE;
            }

            int middle = first + (last - first) / 2;

            if (arr[middle] == element) {
                return middle;
            } else if (element < arr[middle]) {
                return helper(arr, first, middle - 1, element);
            } else {
                return helper(arr, middle + 1, last, element);
            }
        }

    }
}

