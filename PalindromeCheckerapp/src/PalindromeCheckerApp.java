import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        // Original String
        String original = "radar";

        // 🔁 Convert String to Character Array
        char[] characters = original.toCharArray();

        // Two-pointer variables
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        // 🔎 Compare characters using two-pointer technique
        while (start < end) {

            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }
}