import java.io.File;
import java.util.Scanner;

public class Lab4a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file pathname to check: ");
        String pathname = scanner.nextLine();

        File file = new File(pathname);

        if (file.exists()) {
            System.out.println("File exists.");
            if (file.isDirectory()) {
                System.out.println("It is a directory.");
            } else {
                System.out.println("It is a file.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}
