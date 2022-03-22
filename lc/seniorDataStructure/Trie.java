package lc.seniorDataStructure;

/**
 * Description:
 * date: 2022/3/22 15:28
 *
 * @author huajie.zuo
 */
public class Trie {
    class Node {
        private Node[] children;
        private boolean isWord;

        Node() {
            children = new Node[26];
        }
    }

    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node rootCopy = root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            if (rootCopy.children[c - 'a'] == null) {
                rootCopy.children[c - 'a'] = new Node();
            }
            rootCopy = rootCopy.children[c - 'a'];
        }
        rootCopy.isWord = true;
    }

    public boolean search(String word) {
        Node rootCopy = root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            if (rootCopy.children[c - 'a'] == null) {
                return false;
            }
            rootCopy = rootCopy.children[c - 'a'];
        }
        return rootCopy.isWord;
    }

    public boolean startWith(String prefix) {
        Node rootCopy = root;
        char[] cs = prefix.toCharArray();
        for (char c : cs) {
            if (rootCopy.children[c - 'a'] == null) {
                return false;
            }
            rootCopy = rootCopy.children[c - 'a'];
        }
        return true;
    }
}
