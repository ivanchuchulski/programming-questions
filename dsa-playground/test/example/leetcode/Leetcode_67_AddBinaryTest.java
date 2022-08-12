package example.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Leetcode_67_AddBinaryTest {
    @Test
    void testAdding1() {
        String left = "1";
        String right = "11";
        String expectedResult = "100";

        String actualResult = new Leetcode_67_AddBinary().addBinary(left, right);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdding2() {
        String left = "1010";
        String right = "1011";
        String expectedResult = "10101";

        String actualResult = new Leetcode_67_AddBinary().addBinary(left, right);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdding3() {
        String left = "11";
        String right = "111";
        String expectedResult = "1010";

        String actualResult = new Leetcode_67_AddBinary().addBinary(left, right);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdding4() {
        String left = "10";
        String right = "01";
        String expectedResult = "11";

        String actualResult = new Leetcode_67_AddBinary().addBinary(left, right);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdding5() {
        String left = "100";
        String right = "110010";
        String expectedResult = "110110";

        String actualResult = new Leetcode_67_AddBinary().addBinary(left, right);

        assertEquals(expectedResult, actualResult);
    }
}