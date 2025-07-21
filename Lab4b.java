import java.io.*;

public class Lab4b {
    public static void main(String[] args) {
        String fileName = "Utsarga.txt";
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        File file = new File(desktopPath, fileName);

        String contentToWrite = "Hello! This is a test file.\nWelcome to Java file handling.\nThis is line 3.";

        // Write using FileWriter
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(contentToWrite);
            System.out.println("File created and content written successfully at: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }

        // Read using FileReader and read character by character, collecting lines manually
        System.out.println("\nReading file content line by line:");
        try (FileReader fr = new FileReader(file)) {
            StringBuilder line = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                if (ch == '\n') {
                    System.out.println(line.toString());
                    line.setLength(0); // clear for next line
                } else if (ch != '\r') { // ignore carriage return for Windows files
                    line.append((char) ch);
                }
            }
            // Print last line if file does not end with newline
            if (line.length() > 0) {
                System.out.println(line.toString());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
