// Palindrome Checker Application
// Use Case 7: Deque-Based Optimized Palindrome Checker

import java.util.Stack;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeChecker {

    public static void main(String[] args) {

        String word = "level";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            stack.push(ch);
            queue.add(ch);
            deque.addLast(ch);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < word.length(); i++) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
