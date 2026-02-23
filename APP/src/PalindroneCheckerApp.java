import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - UC6 ===");
        System.out.print("Enter a string or number: ");
        String original = scanner.nextLine();

        // Clean string: remove non-alphanumeric chars and convert to lowercase
        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and push characters
        for (int i = 0; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            queue.add(c);  // Enqueue
            stack.push(c); // Push
        }

        // Compare dequeue vs pop
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}