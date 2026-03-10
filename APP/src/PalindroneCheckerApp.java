import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    // Stack method
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque method
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // Recursive method
    public static boolean recursivePalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - UC13 ===");
        System.out.print("Enter a string or number: ");
        String input = scanner.nextLine();

        // Normalize string
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Stack performance
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(cleaned);
        long endStack = System.nanoTime();

        // Deque performance
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(cleaned);
        long endDeque = System.nanoTime();

        // Recursive performance
        long startRec = System.nanoTime();
        boolean recResult = recursivePalindrome(cleaned, 0, cleaned.length() - 1);
        long endRec = System.nanoTime();

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Stack Method: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Method: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Recursive Method: " + recResult +
                " | Time: " + (endRec - startRec) + " ns");

        scanner.close();
    }
}