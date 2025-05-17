package logic.ux.init;

import logic.find.Finders;
import logic.obj.uao.UAOAdders;
import logic.obj.uao.UAOHandler;

public class InitPrompt implements Initializer {
    @Override
    public void init() {
        initPrompt();
    }

    public static void initPrompt() {
        UAOAdders.promptAdder.addAllInitUAO();
    }
}
