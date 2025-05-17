package logic.obj.uao.prompt;

import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOHandler;
import models.Prompt;

public class PromptAdder extends UAOHandler implements UAOAdder {
    private static Prompt prompt;
    private static String name;
    private static String inputField;
    private static String instruction;
    private static String format;

    @Override
    public void addAllInitUAO() {
        addAllInitPrompts();
    }

    private static void addAllInitPrompts() {
        agendaPrompt();
        bookPrompt();
        changePrompt();
        busyDaysPrompt();
        findPrompt();
        findSlotPrompt();
        holidayPrompt();
        mergePrompt();
        unbookPrompt();
    }

    @Override
    public void addUAO() {
        addPrompt();
    }

    private static void addPrompt() {
        prompt = new Prompt(name, inputField, instruction, format);
        UAOHandler.userActionObjects.add(prompt);
    }

    private static void agendaPrompt() {
        name = "agenda";
        inputField = "Day";
        instruction = "Input day to view (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();
    }

    private static void bookPrompt() {
        name = "book";
        inputField = "Day";
        instruction = "Input date's day (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();

        inputField = "LocalTime";
        instruction = "Input date's start time (0 to exit)";
        format = "format: HH:mm";
        addPrompt();

        inputField = "LocalTime";
        instruction = "Input date's end time (0 to exit)";
        format = "format: HH:mm";
        addPrompt();

        inputField = "String";
        instruction = "Input date's name (0 to exit)";
        format = "no special characters";
        addPrompt();

        inputField = "String";
        instruction = "Input date's note (0 to exit)";
        format = "no special characters";
        addPrompt();
    }

    private static void busyDaysPrompt() {
        name = "busyDays";
        inputField = "Day";
        instruction = "From which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();

        inputField = "Day";
        instruction = "To which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();
    }

    private static void changePrompt() {
        name = "change";
        inputField = "Day";
        instruction = "Input date's day (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();

        inputField = "LocalTime";
        instruction = "Input date's start time (0 to exit)";
        format = "format: HH:mm";
        addPrompt();

        inputField = "DateFieldNames";
        instruction = "Input which field to change (0 to exit)";
        format = "format: a single digit from 1 to 5 for day, start time, end time, name or note";
        addPrompt();
    }

    private static void findPrompt() {
        name = "find";
        inputField = "String";
        instruction = "Find all dates that include these characters in their names and/or notes (0 to exit)";
        format = "format: no special characters";
        addPrompt();
    }

    private static void findSlotPrompt() {
        name = "findSlot";
        inputField = "Day";
        instruction = "From which day to search for slot? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();

        inputField = "int";
        instruction = "How many hours long should the slot be? (0 to exit)";
        format = "format: any digit from 1 to 8";
        addPrompt();

        inputField = "String";
        instruction = "From which save file's calendar to search in addition to the loaded one? (* for none, 0 to exit)";
        format = "format: letters only, ends with .txt";
        addPrompt();
    }

    private static void holidayPrompt() {
        name = "holiday";
        inputField = "Day";
        instruction = "Change which day's holiday status? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();
    }

    private static void mergePrompt() {
        name = "merge";
        inputField = "String";
        instruction = "Which save file to merge into current calendar? (0 to exit)";
        format = "format: letters only, ends with .txt";
        addPrompt();
    }

    private static void unbookPrompt() {
        name = "unbook";
        inputField = "Day";
        instruction = "Remove from which day? (0 to exit)";
        format = "format: dd-MM-yyyy";
        addPrompt();
    }
}