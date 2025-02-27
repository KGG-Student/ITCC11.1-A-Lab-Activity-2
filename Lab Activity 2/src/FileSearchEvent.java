public class FileSearchEvent {
    private final String filePath;

    FileSearchEvent(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
