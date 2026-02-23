
import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        String original = "madam";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < original.length(); i++) {
            char poppedChar = stack.pop();

            if (original.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }
    }
}