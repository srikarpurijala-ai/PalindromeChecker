// Palindrome Checker Application
// Use Case 11: Object-Oriented Palindrome Service
// Use Case 12: Strategy Pattern for Palindrome Algorithms

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

// Object-Oriented Palindrome Service
class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String word) {
        return strategy.checkPalindrome(word);
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
}

// Main class
public class PalindromeChecker {

    public static void main(String[] args) {

        String word = "level";

        // Create service using Stack strategy
        PalindromeService service = new PalindromeService(new StackStrategy());

        boolean result = service.checkPalindrome(word);

        // Display result
        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome (Stack Strategy).");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome (Stack Strategy).");
        }

        // Switch to Deque strategy
        service.setStrategy(new DequeStrategy());
        result = service.checkPalindrome(word);

        if (result) {
            System.out.println("The word \"" + word + "\" is a Palindrome (Deque Strategy).");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome (Deque Strategy).");
        }
    }
}
