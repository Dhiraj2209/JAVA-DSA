//A pangram is a sentence that contains every letter of the alphabet at least once.

public class Pangram {

    public static boolean isPangram(String input) {
        // Normalize the input string: convert to lowercase
        String normalizedInput = input.toLowerCase();
        
        // Array to keep track of which letters have been seen
        boolean[] lettersSeen = new boolean[26];
        
        // Iterate over the characters in the input string
        for (char c : normalizedInput.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Mark the letter as seen
                lettersSeen[c - 'a'] = true;
            }
        }
        
        // Check if all letters have been seen
        for (boolean seen : lettersSeen) {
            if (!seen) {
                return false; // If any letter is missing, it's not a pangram
            }
        }
        
        return true; // All letters are present, it's a pangram
    }

    public static void main(String[] args) {
        String testString1 = "The quick brown fox jumps over the lazy dog";
        String testString2 = "Hello World";

        System.out.println("Is pangram: " + isPangram(testString1)); // Should print: true
        System.out.println("Is pangram: " + isPangram(testString2)); // Should print: false
    }
}
