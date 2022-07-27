// 35-seach-insert-position.java

public class Main {
    public static void main(String[] args) {
        var sol = new Solution();

        printTestCase(2, sol.searchInsert(new int[]{1, 2, 3, 4}, 3));   
        printTestCase(3, sol.searchInsert(new int[]{1, 2, 3, 4}, 4));
        printTestCase(4, sol.searchInsert(new int[]{1, 2, 3, 4}, 10));
        printTestCase(1, sol.searchInsert(new int[]{1, 3, 5, 7, 9, 11, 13}, 3));

        System.out.println();

        printTestCase(2, sol.searchInsert(new int[]{1, 3, 5, 6}, 5));

        printTestCase(1, sol.searchInsert(new int[]{1, 3, 5, 6}, 2));
        printTestCase(4, sol.searchInsert(new int[]{1, 3, 5, 6}, 7));

        printTestCase(0, sol.searchInsert(new int[]{1, 3, 5, 6}, 0));
        printTestCase(3, sol.searchInsert(new int[]{1, 3, 5, 7}, 6));

        printTestCase(0, sol.searchInsert(new int[]{1, 3}, 0));
        printTestCase(2, sol.searchInsert(new int[]{1, 3}, 10));
    }
    
    private static void printTestCase(int expected, int actual) {
        System.out.printf("expected : %d, actual: %d%n", expected, actual);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearchRecursive(nums, 0, nums.length - 1, target);    
    }

    private int binarySearchRecursive(int[] nums, int begin, int end, int target) {
        if (end < begin) {
            if (end < 0) return 0;
            else if (begin > nums.length) return nums.length;
            else return begin;
        }

        int mid = begin + ((end - begin) / 2);

        int current = nums[mid];

        if (current == target) {
            return mid;
        } 

        // if (begin == end) {
        //     // in this case the target we determine where should we inserted the element
        //     // System.out.println("begin :" + begin);
        //     // System.out.println("end :" + end);
        //     // System.out.println("num[mid] :" + nums[mid]);

        //     if (target > current) {
        //         return begin + 1;
        //     } 
        //     else {
        //         if (current == nums[0]) {
        //             return 0;
        //         } 
        //         else if (current == nums[nums.length - 1]) {
        //             return nums.length - 1;
        //         }
        //         else {
        //             return begin - 1;
        //         }
        //     }
        // }

        if (current > target) {
            return binarySearchRecursive(nums, begin, mid - 1, target);
        } 
        else {
            return binarySearchRecursive(nums, mid + 1, end, target);
        }
    }
}
