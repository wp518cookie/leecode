package geekbang.tanchao.dict;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-02
 * https://leetcode.com/problems/word-search-ii/
 */

public class FindWords {
    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0] = new char[]{'o', 'a', 'a', 'n'};
        board[1] = new char[]{'e', 't', 'a', 'e'};
        board[2] = new char[]{'i', 'h', 'k', 'r'};
        board[3] = new char[]{'i', 'f', 'l', 'v'};
        String[] words = new String[]{
                "oath", "pea", "eat", "rain"
        };
        FindWords findWords = new FindWords();
        findWords.findWords(board, words);
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rowLen = board.length;
        int colLen = board[0].length;
        Graph g = new Graph(0, rowLen * colLen);
        ArrayList<Integer>[] lists = new ArrayList[26];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int idx = i * colLen + j;
                Bag bag = g.init(idx, board[i][j]);
                setAdj(i, j, rowLen, colLen, bag, board);
                int charIdx = board[i][j] - 'a';
                if (lists[charIdx] == null) {
                    lists[charIdx] = new ArrayList();
                    lists[charIdx].add(idx);
                } else {
                    lists[charIdx].add(idx);
                }
            }
        }
        Set<String> sets = new HashSet();
        for (String word : words) {
            char firstChar = word.charAt(0);
            int idx = firstChar - 'a';
            List<Integer> list = lists[idx];
            if (list == null || list.size() == 0) {
                continue;
            }
            for (int t : list) {
                if (findWord(g, t, sets, word, 1)) {
                    break;
                }
            }
        }
        List<String> result = new ArrayList<>(sets.size());
        for (String s : sets) {
            result.add(s);
        }
        return result;
    }

    public boolean findWord(Graph g, int idx, Set<String> result, String word, int searchIdx) {
        if (searchIdx >= word.length()) {
            result.add(word);
            return true;
        }
        Bag bag = g.adj(idx);
        Iterator<Node> it = bag.iterator();
        char t = word.charAt(searchIdx);
        while (it.hasNext()) {
            Node n = it.next();
            if (n.val == t && findWord(g, n.idx, result, word, searchIdx + 1)) {
                break;
            }
        }
        return false;
    }

    public void setAdj(int row, int col, int rowLen, int colLen, Bag bag, char[][] board) {
        if (row - 1 >= 0) {
            int idx = (row - 1) * colLen + col;
            bag.add(new Node(idx, board[row - 1][col]));
        }
        if (row + 1 < rowLen) {
            int idx = (row + 1) * colLen + col;
            bag.add(new Node(idx, board[row + 1][col]));
        }
        if (col - 1 >= 0) {
            int idx = row * colLen + col - 1;
            bag.add(new Node(idx, board[row][col - 1]));
        }
        if (col + 1 < colLen) {
            int idx = row * colLen + col + 1;
            bag.add(new Node(idx, board[row][col + 1]));
        }
    }

    private static class Graph {
        int v;
        Bag[] bags;

        public Graph(int v, int count) {
            this.v = v;
            bags = new Bag[count];
        }

        public Bag init(int idx, char val) {
            Bag result = new Bag(val);
            bags[idx] = result;
            return result;
        }

        public Bag adj(int idx) {
            return bags[idx];
        }

        public Bag[] adjs() {
            return bags;
        }
    }

    private static class Bag<T> implements Iterable {
        public Bag(char val) {
            this.val = val;
        }

        char val;
        Node first;

        @Override
        public Iterator iterator() {
            return new ListIterator(first);
        }

        public void add(Node node) {
            if (first == null) {
                first = node;
            } else {
                Node next = first;
                first = node;
                first.next = next;
            }
        }
    }

    private static class ListIterator implements Iterator {
        private Node current;
        private Node pre;

        public ListIterator(Node first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            pre = current;
            Node result = current;
            current = current.next;
            return result;
        }
    }

    public static class Node {
        public int idx;
        public char val;
        public Node next;

        public Node(int idx, char val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
