

// Palindrome Checker Application
// Use Case 9: Recursive Palindrome Checker
// Use Case 10: Case-Insensitive & Space-Ignored Palindrome

public class PalindromeChecker {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String word, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {

        // Word for recursive palindrome check
        String word = "level";

        // Call recursive function
        boolean result = isPalindrome(word, 0, word.length() - 1);

        // Print result
        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        // Original string for case-insensitive & space-ignored check
        String sentence = "A man a plan a canal Panama";

        // Normalize string: remove spaces and convert to lowercase
        String normalized = sentence.replaceAll("\\s+", "").toLowerCase();

        // Reverse the normalized string
        String reversed = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed = reversed + normalized.charAt(i);
        }

        // Check palindrome
        if (normalized.equals(reversed)) {
            System.out.println("The sentence \"" + sentence + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The sentence \"" + sentence + "\" is NOT a Palindrome.");
        }
    }
}



