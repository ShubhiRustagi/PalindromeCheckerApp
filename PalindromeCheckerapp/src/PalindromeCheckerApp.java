import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleaned.toCharArray())
            stack.push(c);

        for (char c : cleaned.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleaned.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;

        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        String[] names = {"Stack Strategy", "Deque Strategy", "Two Pointer Strategy"};

        for (int i = 0; i < strategies.size(); i++) {

            long startTime = System.nanoTime();

            boolean result = strategies.get(i).check(input);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("\n" + names[i]);
            System.out.println("Result: " + (result ? "Palindrome" : "Not Palindrome"));
            System.out.println("Execution Time (ns): " + duration);
        }

        scanner.close();
    }
}