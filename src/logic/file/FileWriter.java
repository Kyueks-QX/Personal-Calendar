package logic.file;

//writes from text into the file
public class FileWriter extends FileHandler {
    public static void writeToFile() {
        try {
            fileWriter.write(text);
        } catch (Exception e) {
            throw new RuntimeException("Error writing file");
        }
    }
}
