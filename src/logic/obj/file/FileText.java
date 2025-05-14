package logic.obj.file;

public class FileText extends FileHandler {
    public static void setText(String text) {
        FileHandler.text = text;
    }

    public static String getText() {
        return text;
    }
}
