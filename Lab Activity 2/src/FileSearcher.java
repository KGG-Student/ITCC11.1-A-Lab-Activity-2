import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    private final List<FileSearchListener> listeners = new ArrayList<>();
    private final List<String> results = new ArrayList<>();

    
    void addListener(FileSearchListener listener) {
        listeners.add(listener);
    }

   
    private void triggerEvent(String filePath) {
        FileSearchEvent event = new FileSearchEvent(filePath);
    for (FileSearchListener listener : listeners) {
            listener.onFileFound(event);
        }
    }

   
    void searchFiles(File directory, String extension) {
    if (directory.isDirectory()) {
        File[] files = directory.listFiles();
    if (files != null) {
    for (File file : files) {
        if (file.isDirectory()) {
        searchFiles(file, extension);
                    } 
    else if (file.getName().endsWith(extension)) {
            String filePath = file.getAbsolutePath();
            results.add(filePath);
            triggerEvent(filePath);
                    }
                }
            }
        }
    }

  
    void saveResultsToFile() {
        try (FileWriter writer = new FileWriter("search_results.txt")) {
            for (String result : results) {
                writer.write(result + "\n");
            }
            System.out.println("Search completed. Results saved to search_results.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
