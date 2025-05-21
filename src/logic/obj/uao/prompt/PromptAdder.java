package logic.obj.uao.prompt;

import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Prompt;

public class PromptAdder extends UAOHandler implements UAOAdder {
    private Prompt prompt;
    private UAONames name;
    private String inputField;
    private String instruction;
    private String format;

    @Override
    public void addAllInitUAO() {
        agendaPrompt();
        bookPrompt();
        changePrompt();
        busyDaysPrompt();
        findPrompt();
        findSlotPrompt();
        holidayPrompt();
        mergePrompt();
        unbookPrompt();
        filePrompt();
    }

    @Override
    public void addUAO() {
        prompt = PromptMaker.makePrompt(name, inputField, instruction, format);
        UAOHandler.userActionObjects.add(prompt);
    }

    private void agendaPrompt() {
        name = UAONames.PROMPT_AGENDA;
        inputField = "Day";
        instruction = "Input day to view (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();
    }

    private void bookPrompt() {
        name = UAONames.PROMPT_BOOK_DAY;
        inputField = "Day";
        instruction = "Input date's day (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();

        name = UAONames.PROMPT_BOOK_STARTTIME;
        inputField = "LocalTime";
        instruction = "Input date's start time (0 to exit)";
        format = "format: HH:mm";
        addUAO();

        name = UAONames.PROMPT_BOOK_ENDTIME;
        inputField = "LocalTime";
        instruction = "Input date's end time (0 to exit)";
        format = "format: HH:mm";
        addUAO();

        name = UAONames.PROMPT_BOOK_NAME;
        inputField = "String";
        instruction = "Input date's name (0 to exit)";
        format = "no special characters";
        addUAO();

        name = UAONames.PROMPT_BOOK_NOTE;
        inputField = "String";
        instruction = "Input date's note (0 to exit)";
        format = "no special characters";
        addUAO();
    }

    private void busyDaysPrompt() {
        name = UAONames.PROMPT_BUSYDAYS_FROM;
        inputField = "Day";
        instruction = "From which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();

        name = UAONames.PROMPT_BUSYDAYS_TO;
        inputField = "Day";
        instruction = "To which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();
    }

    private void changePrompt() {
        name = UAONames.PROMPT_CHANGE_DAY;
        inputField = "Day";
        instruction = "Input date's day (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();

        name = UAONames.PROMPT_CHANGE_STARTTIME;
        inputField = "LocalTime";
        instruction = "Input date's start time (0 to exit)";
        format = "format: HH:mm";
        addUAO();

        name = UAONames.PROMPT_CHANGE_DATEFIELD;
        inputField = "DateFieldNames";
        instruction = "Input which field to change (0 to exit)";
        format = "format: a single digit from 1 to 5 for day, start time, end time, name or note";
        addUAO();
    }

    private void findPrompt() {
        name = UAONames.PROMPT_FIND;
        inputField = "String";
        instruction = "Find all dates that include these characters in their names and/or notes (0 to exit)";
        format = "format: no special characters";
        addUAO();
    }

    private void findSlotPrompt() {
        name = UAONames.PROMPT_FINDSLOT_FROMDAY;
        inputField = "Day";
        instruction = "From which day to search for slot? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();

        name = UAONames.PROMPT_FINDSLOT_HOURS;
        inputField = "int";
        instruction = "How many hours long should the slot be? (0 to exit)";
        format = "format: any digit from 1 to 8";
        addUAO();

        name = UAONames.PROMPT_FINDSLOT_FILENAME;
        inputField = "String";
        instruction = "From which save file's calendar to search in addition to the loaded one? (* for none, 0 to exit)";
        format = "format: letters only, .txt is automatically appended";
        addUAO();
    }

    private void holidayPrompt() {
        name = UAONames.PROMPT_HOLIDAY;
        inputField = "Day";
        instruction = "Change which day's holiday status? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();
    }

    private void mergePrompt() {
        name = UAONames.PROMPT_MERGE;
        inputField = "String";
        instruction = "Which save file to merge into current calendar? (0 to exit)";
        format = "format: letters only, .txt is automatically appended";
        addUAO();
    }

    private void unbookPrompt() {
        name = UAONames.PROMPT_UNBOOK;
        inputField = "Day";
        instruction = "Remove from which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addUAO();
    }

    private void filePrompt() {
        name = UAONames.PROMPT_SAVE_CHANGE;
        inputField = "String";
        instruction = "What's the name of the new file? (0 to exit)";
        format = "format: letters only, .txt is automatically appended";
        addUAO();
    }
}