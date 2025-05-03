package logic.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//all classes which handle files inherit this
public abstract class FileHandler {
    public static String fileName;
    public static String text;
    public static File file;
    public static FileReader fileReader;
    public static FileWriter fileWriter;
}
