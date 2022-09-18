package example.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void testSearchingAWordToTrie() {
        String word = "mother";
        String subword = word.substring(0, 3);

        Trie trie = new Trie();

        trie.insert(word);

        assertTrue(trie.contains(word));
        assertFalse(trie.contains(subword));
    }

    @Test
    void testSearchingAWordToTrie2() {
        String word1 = "mother";
        String word2 = "father";
        String subword1 = word1.substring(0, 3);
        String subword2 = word1.substring(0, 2);

        Trie trie = new Trie();

        trie.insert(word1);
        trie.insert(word2);

        assertTrue(trie.contains(word1));
        assertTrue(trie.contains(word2));

        assertFalse(trie.contains(subword1));
        assertFalse(trie.contains(subword2));
    }

    @Test
    void testSearchingAWordToTrie3() {
        String word = "thisiSaverylongsequenceofWords!!d@";
        String subword = word.substring(3, 7);

        Trie trie = new Trie();

        trie.insert(word);
        trie.insert(subword);

        assertTrue(trie.contains(word));
        assertTrue(trie.contains(subword));
    }
}