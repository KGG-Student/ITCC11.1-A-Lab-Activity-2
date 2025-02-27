import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveFileSearch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FileSearcher fileSearcher = new FileSearcher();

            fileSearcher.addListener(event -> System.out.println("File found: " + event.getFilePath()));

            System.out.print("Enter directory path to search or create: ");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);
            if (!directory.exists()) {
                System.out.print("Directory does not exist. Do you want to create it? (yes/no): ");
                String createDir = scanner.nextLine();
                if (createDir.equalsIgnoreCase("yes")) {
                    if (directory.mkdirs()) {
                        System.out.println("Directory created successfully.");
                    } else {
                        System.out.println("Failed to create directory.");
                        return;
                    }
                } else {
                    System.out.println("Exiting program.");
                    return;
                }
            }

            System.out.print("Enter file extension to search for (e.g., txt, java): ");
            String extension = scanner.nextLine();

            if (!extension.startsWith(".")) {
                extension = "." + extension;
            }

            System.out.print("Do you want to create a test file in this directory? (yes/no): ");
            String createFile = scanner.nextLine();
            if (createFile.equalsIgnoreCase("yes")) {
                System.out.print("Enter file name (with extension, e.g., test.txt): ");
                String fileName = scanner.nextLine();
                File newFile = new File(directory, fileName);

            try {
                if (newFile.createNewFile()) {
                    System.out.println("File created: " + newFile.getAbsolutePath());
                    }
                else {
                    System.out.println("File already exists.");
                    }
                } 
                catch (IOException e) {
                    System.out.println("Error creating file: " + e.getMessage());
                }
            }

            System.out.println("Searching for files with extension " + extension + "...");
            fileSearcher.searchFiles(directory, extension);

            fileSearcher.saveResultsToFile();
        }
    }
}
