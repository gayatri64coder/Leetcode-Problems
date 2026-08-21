class Solution {

    Node root;

    static class Node {
        Node[] children;
        boolean eow;

        Node() {
            children = new Node[26];
            eow = false;
        }
    }

    // Insert word into Trie
    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // Word Break using Trie + Memoization
    public boolean wordbreak(String s, int start, Boolean[] memo) {

        // Reached end of string
        if (start == s.length()) {
            return true;
        }

        // Already calculated
        if (memo[start] != null) {
            return memo[start];
        }

        Node curr = root;

        // Try every possible prefix starting at 'start'
        for (int end = start; end < s.length(); end++) {

            int idx = s.charAt(end) - 'a';

            // No matching Trie path
            if (curr.children[idx] == null) {
                break;
            }

            curr = curr.children[idx];

            // Found a valid word
            if (curr.eow) {

                // Check remaining string
                if (wordbreak(s, end + 1, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        // No valid segmentation found
        memo[start] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        // Create a fresh Trie for every test case
        root = new Node();

        // Insert dictionary words
        for (String word : wordDict) {
            insert(word);
        }

        // Memoization array
        Boolean[] memo = new Boolean[s.length()];

        return wordbreak(s, 0, memo);
    }
}