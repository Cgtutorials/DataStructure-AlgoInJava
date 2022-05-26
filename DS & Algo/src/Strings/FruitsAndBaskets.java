package Strings;

public class FruitsAndBaskets {
    public static int findLength(char[] arr) {
        // TODO: Longest Substring with K Distinct Characters where K=2.
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                FruitsAndBaskets.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                FruitsAndBaskets.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
