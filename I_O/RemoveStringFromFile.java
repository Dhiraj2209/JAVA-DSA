import java.io.*;

public class RemoveStringFromFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java RemoveStringFromFile <string_to_remove> <filename>");
            return;
        }

        String stringToRemove = args[0];
        String filename = args[1];

        try {
            File inputFile = new File(filename);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace(stringToRemove, "");
                writer.write(line + System.getProperty("line.separator"));
            }

            reader.close();
            writer.close();

            // Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Failed to delete the original file");
                return;
            }

            // Rename the temp file to the original file name
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Failed to rename the temp file");
                return;
            }

            System.out.println("String '" + stringToRemove + "' removed from the file successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
