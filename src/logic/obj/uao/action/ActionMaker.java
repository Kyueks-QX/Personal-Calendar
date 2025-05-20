package logic.obj.uao.action;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Action;

import java.util.function.Function;

public class ActionMaker extends UAOHandler {
    /**
     * deez nuts
     * @param name
     * @param function
     * @return
     */
    public static Action makeAction(UAONames name, Function<Void, Integer> function) {
        return new Action.Builder()
                .withName(name)
                .withFunction(function)
                .build();
    }
}
