package logic.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//all classes which handle files inherit this
public abstract class FileHandler {
    protected static String fileName;
    protected static String text;
    protected static File file;
    protected static FileReader fileReader;
    protected static FileWriter fileWriter;
}
