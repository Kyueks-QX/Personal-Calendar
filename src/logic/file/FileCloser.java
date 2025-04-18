package logic.file;

import java.io.File;
import java.io.IOException;

//Closes files.
public class FileCloser extends FileHandler {
    public static void closeFile() {
        try
        {
            fileReader.close();
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException("Error with file closing");
        }
    }
}
