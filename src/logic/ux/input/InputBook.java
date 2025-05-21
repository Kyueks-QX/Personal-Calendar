package logic.ux.input;

import logic.obj.calendar.CalendarBook;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.prompt.PromptChainMaker;
import logic.ux.output.OutputUAO;
import models.calendar.Day;
import models.uao.Prompt;
import models.uao.PromptChain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InputBook extends InputHandler {
    private static LocalDate localDate;

    public static Integer input(Void v) {
        UAOHandler.menuArgs.clear();

        PromptChain promptChain = new PromptChain();
        promptChain.setPromptChain(PromptChainMaker.makePromptChain(
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_DAY),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_STARTTIME),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_ENDTIME),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_NAME),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_NOTE)
        ));

        try {
            for (Prompt prompt : promptChain.getPromptChain()) {
                if (inputBook(prompt) == 1) {
                    return -3;
                }
            }
        } catch (Exception e) {
            System.out.println("Parsing Error!: " + e);
            return -2;
        }

        for (int i = 0; i < UAOHandler.menuArgs.size(); i++) {
            if (UAOHandler.menuArgs.get(i) == null) {
                return -1;
            }
        }

        return CalendarBook.book(
                (Day) UAOHandler.menuArgs.get(0),
                (LocalTime) UAOHandler.menuArgs.get(1),
                (LocalTime) UAOHandler.menuArgs.get(2),
                (String) UAOHandler.menuArgs.get(3),
                (String) UAOHandler.menuArgs.get(4)
        );
    }

    public static int inputBook(Prompt prompt) {
        UAOHandler.currentUAO = prompt;
        OutputUAO.printUAO();
        inputText = scanner.nextLine();

        try {
            if (Integer.parseInt(inputText) == 0) { return 1; }
        } catch (Exception _) { }

        switch (prompt.getName()) {
            case PROMPT_BOOK_DAY: {
                localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                UAOHandler.menuArgs.add(new Day(localDate));
                break;
            }
            case PROMPT_BOOK_STARTTIME, PROMPT_BOOK_ENDTIME: {
                UAOHandler.menuArgs.add(LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                break;
            }
            case PROMPT_BOOK_NAME, PROMPT_BOOK_NOTE: {
                UAOHandler.menuArgs.add(inputText);
                break;
            }
        }

        return 0;
    }
}
