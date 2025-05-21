package logic.file;

/**
 * Class for getting/setting the currently used file name.
 */
public class FileName extends FileHandler {
    /**
     * Sets the file name.
     * @param fileName
     * The name of the file. .txt extension only.
     * @return
     * Returns 0 if the file was successfully set, 1 otherwise.
     */
    public static int setFileName(String fileName) {
        logic.file.FileHandler.fileName = fileName;
        return 0;
    }

    /**
     * @return
     * Returns the file name.
     */
    public static String getFileName() {
        return logic.file.FileHandler.fileName;
    }
}
