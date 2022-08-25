package example.leetcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Leetcode_69_SqrtTest {
    @Test
    void test1() {
        int x = 8;
        int expectedSqrt = 2;

        int actual = new Leetcode_69_Sqrt().mySqrt(x);

        assertEquals(expectedSqrt, actual);
    }

    @Test
    void test2() {
        int x = 256;
        int expectedSqrt = 16;

        int actual = new Leetcode_69_Sqrt().mySqrt(x);

        assertEquals(expectedSqrt, actual);
    }

    @Test
    void test3() {
        int x = 2_147_395_600;
        int expectedSqrt = 46340;

        int actual = new Leetcode_69_Sqrt().mySqrt(x);

        assertEquals(expectedSqrt, actual);
    }

    @Test
    void test4() {
        int x = Integer.MAX_VALUE;
        int expectedSqrt = 46340;

        int actual = new Leetcode_69_Sqrt().mySqrt(x);

        assertEquals(expectedSqrt, actual);
    }

    @Test
    void test5() {
        int x = 2147395599;
        int expectedSqrt = 46339;

        int actual = new Leetcode_69_Sqrt().mySqrt(x);

        assertEquals(expectedSqrt, actual);
    }
}