import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStatsCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileStatsCounter <filename>");
            return;
        }

        String filename = args[0];

        int characterCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                characterCount += line.length();

                // Splitting the line into words by whitespace characters
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Character count: " + characterCount);
        System.out.println("Word count: " + wordCount);
        System.out.println("Line count: " + lineCount);
    }
}