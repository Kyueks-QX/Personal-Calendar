package logic.obj.file;

import java.nio.file.Files;
import java.nio.file.Path;

//reads from file into the text
public class FileReader extends FileHandler {
    public static void readFromFile() {
        try {
            int i;
            while ((i = fileReader.read()) != -1) {
                text.concat(String.valueOf((char)i));
            }
            text = Files.readString(Path.of(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
