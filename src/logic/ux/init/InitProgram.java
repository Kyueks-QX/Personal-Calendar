package logic.ux.init;

public class InitProgram extends InitHandler implements Initializer {
    @Override
    public void init() {
        initProgram();
    }

    public static void initProgram() {
        InitMenu.initMenu();
    }
}
