package example.leetcode;

public class Leetcode_69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x <= 3) {
            return 1;
        } else {
            int result = 2;
            int square = result * result;

            while (square < x) {
                result++;

                if (result == 46340) {
                    System.out.println("reached upper limit");
                    return x == Integer.MAX_VALUE ? result : result - 1;
                }

                square = result * result;

            }

            return square == x ? result : result - 1;
        }
    }
}
