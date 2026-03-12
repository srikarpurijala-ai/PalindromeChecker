// Palindrome Checker Application
// Use Case 12: Strategy Pattern for Palindrome Algorithms
// Use Case 13: Performance Comparison

import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Utility class for Reverse and Stack methods
class PalindromeUtils {

    // Method 1: Reverse String Approach
    public static boolean checkUsingReverse(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return word.equals(reversed);
    }

    // Method 2: Stack Approach
    public static boolean checkUsingStack(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Main class
public class PalindromeChecker {

    public static void main(String[] args) {

        String word = "level";

        // Measure Reverse Method Time
        long start1 = System.nanoTime();
        boolean result1 = PalindromeUtils.checkUsingReverse(word);
        long end1 = System.nanoTime();

        // Measure Stack Method Time
        long start2 = System.nanoTime();
        boolean result2 = PalindromeUtils.checkUsingStack(word);
        long end2 = System.nanoTime();

        // Using Strategy Pattern (StackStrategy example)
        PalindromeStrategy strategy = new StackStrategy();
        boolean resultStrategy = strategy.checkPalindrome(word);

        // Display results
        System.out.println("Reverse Method Result: " + result1);
        System.out.println("Execution Time (Reverse): " + (end1 - start1) + " ns");
        System.out.println();

        System.out.println("Stack Method Result: " + result2);
        System.out.println("Execution Time (Stack): " + (end2 - start2) + " ns");
        System.out.println();

        if (resultStrategy) {
            System.out.println("Strategy Pattern Result: The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Strategy Pattern Result: The word \"" + word + "\" is NOT a Palindrome.");
        }
    }
}