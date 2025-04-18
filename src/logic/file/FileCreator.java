package logic.file;

public class FileCreator extends FileHandler {
    public static boolean fileCreate() {
        try {
            if (file == null) {
                FileOpener.OpenFile("default.txt");
            }
            return file.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't make file with name " + FileHandler.file);
        }
    }
}