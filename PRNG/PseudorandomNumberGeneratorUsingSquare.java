package PRNG;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PseudorandomNumberGeneratorUsingSquare {
    
    private static final String FILE_PATH = "seed.txt";

    public static void main(String[] args) {
        // Calling the method to update and print the seed value
        updateAndPrintSeed();
    }

    public static void updateAndPrintSeed() {
        // Reading the seed value from the file
        int seed = readSeedFromFile();

        int seedsquare = (int)(seed * seed * 3.14159265352);
        // Updataing the seed value
        String str = String.format("%08d",seedsquare % 100000000);
        seed = (int) (Integer.valueOf(str.substring(3, 7)));

        // Store the updated seed value back to the file
        writeSeedToFile(seed);


        System.out.println("Random Number : " + str.substring(1, 7));
        System.out.println("Updated Seed: " + seed);
    }

    public static int readSeedFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Default seed value if file doesn't exist or cannot be read
        return (int) ((System.nanoTime() / 1000) % 10000);
    }

    public static void writeSeedToFile(int seed) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(Integer.toString(seed));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
