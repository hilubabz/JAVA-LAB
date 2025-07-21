import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Lab4c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            scanner.close();
            return;
        }

        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Executable: " + file.canExecute());

        // Format last modified time
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("Last Modified: " + sdf.format(file.lastModified()));

        scanner.close();
    }
}
