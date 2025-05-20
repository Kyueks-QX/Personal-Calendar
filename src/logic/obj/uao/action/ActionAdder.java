package logic.obj.uao.action;

import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.ux.input.InputBook;
import models.uao.Action;

import java.util.function.Function;

public class ActionAdder extends UAOHandler implements UAOAdder {
    private Action action;
    private UAONames name;
    private Function<Void, Integer> function;

    @Override
    public void addAllInitUAO() {

    }

    @Override
    public void addUAO() {
        action = ActionMaker.makeAction(name, function);
        UAOHandler.userActionObjects.add(action);
    }

    private void bookAction() {
        name = UAONames.ACTION_BOOK;
        function = InputBook::input;
        addUAO();
    }
}
