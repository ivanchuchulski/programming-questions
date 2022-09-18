package example.trie;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node(' '); // first node is not holding anything
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);

            Node node = temp.getNext(symbol);

            if (node == null) {
                node = new Node(symbol);
                temp.setNode(node, symbol);
            }

            temp = temp.getNext(symbol);
        }

        temp.setWordEnd(true);
    }

    public boolean contains(String word) {
        Node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);

            temp = temp.getNext(symbol);

            if (temp == null || temp.getSymbol() != symbol) {
                return false;
            }
        }

        return temp != null && temp.isWordEnd();
    }


    class Node {

        private char symbol;

        private boolean isWordEnd;
        private Node[] next;

        public Node(char symbol) {
            this.symbol = symbol;
            this.isWordEnd = false;
            next = new Node[255];
        }

        public char getSymbol() {
            return symbol;
        }

        public Node getNext(char symbol) {
            return next[symbol];
        }

        public void setNode(Node node, char symbol) {
            next[symbol] = node;
        }

        public void setWordEnd(boolean wordEnd) {
            isWordEnd = wordEnd;
        }

        public boolean isWordEnd() {
            return isWordEnd;
        }
    }
}
