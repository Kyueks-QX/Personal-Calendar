package logic.ux.init;

import logic.file.FileHandler;

public class InitProgram extends InitHandler implements Initializer {
    @Override
    public void init() {
        initProgram();
    }

    public static void initProgram() {
        InitPrompt.initPrompt();
        InitMenu.initMenu();
        InitAction.initAction();
        FileHandler.fileName = "default.txt";
    }
}
