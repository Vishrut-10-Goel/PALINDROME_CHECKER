import java.util.Scanner;

public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - UC3 ===");
        System.out.print("Enter a string or number: ");
        String original = scanner.nextLine();

        // Remove spaces and convert to lowercase
        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = "";

        // Reverse string using for loop
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);   // String concatenation
        }

        // Compare original cleaned string with reversed string
        if (cleaned.equals(reversed)) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}