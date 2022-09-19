package example.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    void testInsertingWordAndGettingItReversesIt() {
        String word = "word";
        String reversedWord = reverseString(word);

        Stack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character popped = stack.pop();
            sb.append(popped);
        }

        assertEquals(reversedWord, sb.toString());
    }

    @Test
    void testInsertingWordAndGettingItReversesIt2() {
        String word = "averylongs eq ! @# unceofWords";
        String reversedWord = reverseString(word);

        Stack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        assertEquals(reversedWord, sb.toString());
    }

    private static String reverseString(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(word.charAt(word.length() - i - 1));
        }

        return stringBuilder.toString();
    }


}