import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - UC7 ===");
        System.out.print("Enter a string or number: ");
        String original = scanner.nextLine();

        // Clean string: remove non-alphanumeric characters and convert to lowercase
        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < cleaned.length(); i++) {
            deque.addLast(cleaned.charAt(i));
        }

        // Compare front and rear characters
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
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