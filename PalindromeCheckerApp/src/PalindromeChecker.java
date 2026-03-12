

// Palindrome Checker Application
// Use Case 8: Linked List Based Palindrome Checker


public class PalindromeChecker {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

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

        String word = "madam";

        // Convert string to linked list
        Node head = null;
        Node tail = null;

        for (int i = 0; i < word.length(); i++) {
            Node newNode = new Node(word.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using fast and slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare halves
        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Call recursive function
        boolean result = isPalindrome(word, 0, word.length() - 1);

        // Print result
        if (isPalindrome) {
            System.out.println("Linked List Check: The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Linked List Check: The word \"" + word + "\" is NOT a Palindrome.");
        }

        if (result) {
            System.out.println("Recursive Check: The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Recursive Check: The word \"" + word + "\" is NOT a Palindrome.");
        }
    }
}



