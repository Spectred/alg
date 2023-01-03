package struct;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) return false; // 不能完全匹配
        else return true;
    }


    public class TrieNode {

        public char data;

        public TrieNode[] children = new TrieNode[26];

        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strs = {"hello", "her", "hi", "how", "see", "so"};
        for (String str : strs) {
            trie.insert(str.toCharArray());
        }

        boolean b1 = trie.find("hello".toCharArray());
        boolean b2 = trie.find("he".toCharArray());
        System.out.println(b1); // true
        System.out.println(b2); // false
    }
}
