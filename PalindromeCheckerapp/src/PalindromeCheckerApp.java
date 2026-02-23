import java.util.*;
import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {

    public class LinkedListPalindrome {

        static class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        // Reverse linked list
        static Node reverse(Node head) {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }

        // Check palindrome
        static boolean isPalindrome(Node head) {

            if (head == null || head.next == null)
                return true;

            Node slow = head;
            Node fast = head;

            // Find middle
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            Node secondHalf = reverse(slow);
            Node firstHalf = head;

            // Compare halves
            while (secondHalf != null) {
                if (firstHalf.data != secondHalf.data)
                    return false;

                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return true;
        }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();

        Node head = null, tail = null;

        // Convert string to linked list
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                Node newNode = new Node(ch);

                if (head == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }

        if (isPalindrome(head))
            System.out.println("The string is a Palindrome.");
        else
            System.out.println("The string is NOT a Palindrome.");

        sc.close();
    }
    }