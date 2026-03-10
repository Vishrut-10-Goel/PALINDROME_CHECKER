import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App - UC10 ===");
        System.out.print("Enter a string or sentence: ");
        String original = scanner.nextLine();

        // Normalize string (remove spaces and convert to lowercase)
        String cleaned = original.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = cleaned.length() - 1;
        boolean isPalindrome = true;

        // Compare characters
        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
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