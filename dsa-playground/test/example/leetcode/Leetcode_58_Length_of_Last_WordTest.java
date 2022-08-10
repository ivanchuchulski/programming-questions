package example.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Leetcode_58_Length_of_Last_WordTest {

    private Leetcode_58_Length_of_Last_Word solution;

    @BeforeEach
    void setUp() {
        solution = new Leetcode_58_Length_of_Last_Word();
    }

    @Test
    void test1() {
        String word = "Hello World";
        int expectedOutput = 5;

        int actualOutput = solution.lengthOfLastWord(word);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2() {
        String word = "   fly me   to   the moon  ";
        int expectedOutput = 4;

        int actualOutput = solution.lengthOfLastWord(word);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test3() {
        String word = "luffy is still joyboy";
        int expectedOutput = 6;

        int actualOutput = solution.lengthOfLastWord(word);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test4() {
        String word = "joyboy";
        int expectedOutput = 6;

        int actualOutput = solution.lengthOfLastWord(word);

        assertEquals(expectedOutput, actualOutput);
    }
}