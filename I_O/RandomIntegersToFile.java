import java.io.*;
import java.util.*;

public class RandomIntegersToFile {
    public static void main(String[] args) {
        String filename = "Practical7.txt";

        try {
            // Create the file if it doesn't exist
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Write 100 random integers separated by spaces into the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                writer.write(Integer.toString(random.nextInt(1000))); // Generating random integers between 0 and 999
                writer.write(" ");
            }
            writer.close();

            // Read the data back from the file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            reader.close();

            // Split the line into tokens and convert them into integers
            String[] tokens = line.split(" ");
            int[] integers = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                integers[i] = Integer.parseInt(tokens[i]);
            }
            //Before Sorting
            System.out.println("Random numbers Before Sorting");
            for (int num : integers) {
                System.out.print(num + " | ");
            }
            System.out.println();

            // Sort the integers in increasing order
            Arrays.sort(integers);

            // Display the sorted integers
            System.out.println("Integers in increasing order:");
            for (int num : integers) {
                System.out.print(num + " ");
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
