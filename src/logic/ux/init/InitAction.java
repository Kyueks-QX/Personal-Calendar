package logic.ux.init;

import logic.obj.uao.UAOAdders;

public class InitAction implements Initializer {
    @Override
    public void init() {
        initAction();
    }

    public static void initAction() {
        UAOAdders.actionAdder.addAllInitUAO();
    }
}
