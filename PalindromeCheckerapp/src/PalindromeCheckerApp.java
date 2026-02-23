import java.util.*
import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create Queue and Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into Queue and Stack
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetterOrDigit(ch)) {  // Ignore spaces & symbols
                ch = Character.toLowerCase(ch);
                queue.add(ch);   // Enqueue (FIFO)
                stack.push(ch);  // Push (LIFO)
            }
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("The string is a Palindrome.");
        else
            System.out.println("The string is NOT a Palindrome.");

        sc.close();
    }
}