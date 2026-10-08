class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(
        String word,
        int index,
        Node curr
    ) {

        if (index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        if (ch == '.') {

            for (int i = 0; i < 26; i++) {

                if (curr.children[i] != null) {

                    if (searchHelper(
                        word,
                        index + 1,
                        curr.children[i]
                    )) {
                        return true;
                    }
                }
            }

            return false;
        }

        int childIndex = ch - 'a';

        if (curr.children[childIndex] == null) {
            return false;
        }

        return searchHelper(
            word,
            index + 1,
            curr.children[childIndex]
        );
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */