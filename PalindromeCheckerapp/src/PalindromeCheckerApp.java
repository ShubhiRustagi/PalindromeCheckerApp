import java.util.*;
import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {

    public class CleanPalindromeCheck {

        public static boolean isPalindrome(String input) {

            // Normalize string (remove special chars & convert to lowercase)
            input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            int left = 0;
            int right = input.length() - 1;

            // Two-pointer comparison
            while (left < right) {
                if (input.charAt(left) != input.charAt(right))
                    return false;

                left++;
                right--;
            }

            return true;
        }

        public static void main(String[] args){ Scanner sc = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            if (isPalindrome(input))
                System.out.println("The string is a Palindrome.");
            else
                System.out.println("The string is NOT a Palindrome.");

            sc.close();
        }
    }