import java.util.*;

class Solution {

    class Node {

        Node[] children = new Node[26];
        String word;
    }

    Node root = new Node();

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        for (String word : words) {
            insert(word);
        }

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(
        char[][] board,
        int row,
        int col,
        Node curr,
        List<String> result
    ) {

        if (row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length) {

            return;
        }

        char ch = board[row][col];

        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        Node next = curr.children[index];

        if (next == null) {
            return;
        }

        if (next.word != null) {

            result.add(next.word);

            next.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, next, result);
        dfs(board, row - 1, col, next, result);
        dfs(board, row, col + 1, next, result);
        dfs(board, row, col - 1, next, result);

        board[row][col] = ch;

        if (isEmpty(next)) {
            curr.children[index] = null;
        }
    }

    private boolean isEmpty(Node node) {

        for (Node child : node.children) {

            if (child != null) {
                return false;
            }
        }

        return node.word == null;
    }
}