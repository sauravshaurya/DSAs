package dsa.practice.sliding.window;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {


    //n^3
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> counts = new HashMap<>(); // Frequencies of chars in the window
        int res = 0;
        int i = 0; // Left pointer

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            counts.put(currentChar, counts.getOrDefault(currentChar, 0) + 1); // Add right pointer to window

            while (counts.get(currentChar) > 1) { // While the element at right pointer created a repeat
                char leftChar = s.charAt(i);
                counts.put(leftChar, counts.get(leftChar) - 1); // While condition not valid, remove element at left pointer from window by decreasing its count, and then increment left pointer. In this case, it is while s[j] is a duplicate (we will stop after removing the duplicate copy of s[j]).
                i++;
            } // Now the condition is valid

            res = Math.max(res, j - i + 1); // Update global max with the length of the current valid substring
        }

        return res;
    }

    //n^2
    public int longestSubstring2(String s) {

        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];

            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)])
                    break;
                else {
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
        }
        return res;
    }

    //helper function for longestSubstring3
    public boolean isValid(String s, int mid) {
        int[] count = new int[256];
        boolean valid = false;
        int distinct = 0;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            if (count[s.charAt(i)] == 1) {
                distinct++;
            }
            if (i >= mid) {
                count[s.charAt(i - mid)]--;
                if (count[s.charAt(i - mid)] == 0) {
                    distinct--;
                }
            }

            if (i >= mid - 1 && distinct == mid) {
                valid = true;
            }

        }

        return valid;
    }

    //nlogn using Binary Search
    public int longestSubstring3(String s) {

        int n = s.length();
        int ans = Integer.MIN_VALUE;
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(s, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }


    //best solution using sliding window, T.C = n
    public int longestSubstring4(String s) {
        int n = s.length();
        int res = 0;
        boolean[] visited = new boolean[256];
        int left = 0, right = 0;

        while (right < n) {

            if (visited[s.charAt(right)]) {

                while (visited[s.charAt(right)]) {
                    visited[s.charAt(left)] = false;
                    left++;
                }
            }

            visited[s.charAt(right)] = true;

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solution = new LongestSubstringWithoutRepeatingChars();
        String input = "abcabc"; // Example input
        int result = solution.longestSubstring4(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
