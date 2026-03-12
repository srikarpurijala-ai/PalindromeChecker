
// Palindrome Checker Application
// Use Case 10: Case-Insensitive & Space-Ignored Palindrome
// Use Case 11: Object-Oriented Palindrome Service

class PalindromeService {

    // Method to check palindrome
    public boolean checkPalindrome(String word) {

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class PalindromeChecker {

    public static void main(String[] args) {

        // Original sentence
        String sentence = "A man a plan a canal Panama";

        // Normalize string: remove spaces and convert to lowercase
        String normalized = sentence.replaceAll("\\s+", "").toLowerCase();

        // Reverse the normalized string
        String reversed = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed = reversed + normalized.charAt(i);
        }

        // Check palindrome ignoring spaces and case
        if (normalized.equals(reversed)) {
            System.out.println("The sentence \"" + sentence + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The sentence \"" + sentence + "\" is NOT a Palindrome.");
        }

        // Word for object-oriented palindrome check
        String word = "madam";

        // Create object of PalindromeService
        PalindromeService service = new PalindromeService();

        // Call method
        boolean result = service.checkPalindrome(word);

        // Display result
        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }
    }
}
