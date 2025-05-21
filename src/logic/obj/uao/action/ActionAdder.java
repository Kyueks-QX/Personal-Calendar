package logic.obj.uao.action;

import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.ux.input.*;
import models.uao.Action;

import java.util.function.Function;

public class ActionAdder extends UAOHandler implements UAOAdder {
    private Action action;
    private UAONames name;
    private Function<Void, Integer> function;

    @Override
    public void addAllInitUAO() {
        agendaAction();
        bookAction();
        busyDaysAction();
        changeAction();
        fileChangeAction();
        fileSaveAction();
        fileLoadAction();
        fileCurrentAction();
        findAction();
        findSlotAction();
        holidayAction();
        mergeAction();
        unbookAction();
    }

    @Override
    public void addUAO() {
        action = ActionMaker.makeAction(name, function);
        UAOHandler.userActionObjects.add(action);
    }

    private void agendaAction() {
        name = UAONames.ACTION_AGENDA;
        function = InputAgenda::input;
        addUAO();
    }

    private void bookAction() {
        name = UAONames.ACTION_BOOK;
        function = InputBook::input;
        addUAO();
    }

    private void busyDaysAction() {
        name = UAONames.ACTION_BUSYDAYS;
        function = InputBusyDays::input;
        addUAO();
    }

    private void changeAction() {
        name = UAONames.ACTION_CHANGE;
        function = InputChange::input;
        addUAO();
    }

    private void fileChangeAction() {
        name = UAONames.ACTION_FILE_CHANGE;
        function = InputFile::input;
        addUAO();
    }

    private void fileSaveAction() {
        name = UAONames.ACTION_FILE_SAVE;
        function = InputFile::save;
        addUAO();
    }

    private void fileLoadAction() {
        name = UAONames.ACTION_FILE_LOAD;
        function = InputFile::load;
        addUAO();
    }

    private void fileCurrentAction() {
        name = UAONames.ACTION_FILE_CURRENT;
        function = InputFile::current;
        addUAO();
    }

    private void findAction() {
        name = UAONames.ACTION_FIND;
        function = InputFind::input;
        addUAO();
    }

    private void findSlotAction() {
        name = UAONames.ACTION_FINDSLOT;
        function = InputFindSlot::input;
        addUAO();
    }

    private void holidayAction() {
        name = UAONames.ACTION_HOLIDAY;
        function = InputHoliday::input;
        addUAO();
    }

    private void mergeAction() {
        name = UAONames.ACTION_MERGE;
        function = InputMerge::input;
        addUAO();
    }

    private void unbookAction() {
        name = UAONames.ACTION_UNBOOK;
        function = InputUnbook::input;
        addUAO();
    }
}
