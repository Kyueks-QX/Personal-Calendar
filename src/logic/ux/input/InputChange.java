package logic.ux.input;

import logic.obj.calendar.CalendarBook;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.prompt.PromptChainMaker;
import logic.ux.output.OutputUAO;
import models.calendar.DateFieldNames;
import models.calendar.Day;
import models.uao.Prompt;
import models.uao.PromptChain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InputChange extends InputHandler {
    public static Integer input(Void v) {
        LocalDate localDate;

        PromptChain promptChain = new PromptChain();
        promptChain.setPromptChain(PromptChainMaker.makePromptChain(
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_CHANGE_DAY),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_CHANGE_STARTTIME),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_CHANGE_DATEFIELD)
        ));

        for (Prompt prompt : promptChain.getPromptChain()) {
            UAOHandler.currentUAO = prompt;
            OutputUAO.printUAO();
            inputText = scanner.nextLine();

            switch (prompt.getName()) {
                case PROMPT_CHANGE_DAY: {
                    localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    UAOHandler.menuArgs.set(0, new Day(localDate));
                    break;
                }
                case PROMPT_CHANGE_STARTTIME: {
                    UAOHandler.menuArgs.set(1, LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                    break;
                }
                case PROMPT_CHANGE_DATEFIELD: {
                    UAOHandler.menuArgs.set(2, DateFieldNames.valueOf(inputText));
                    break;
                }
            }
        }

        Prompt prompt = (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.valueOf(inputText));
        UAOHandler.currentUAO = prompt;
        OutputUAO.printUAO();
        inputText = scanner.nextLine();

        switch (prompt.getName()) {
            case PROMPT_BOOK_DAY: {
                localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                UAOHandler.menuArgs.set(0, new Day(localDate));
                break;
            }
            case PROMPT_BOOK_STARTTIME: {
                UAOHandler.menuArgs.set(1, LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                break;
            }
            case PROMPT_BOOK_ENDTIME: {
                UAOHandler.menuArgs.set(2, LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                break;
            }
            case PROMPT_BOOK_NAME: {
                UAOHandler.menuArgs.set(3, inputText);
                break;
            }
            case PROMPT_BOOK_NOTE: {
                UAOHandler.menuArgs.set(4, inputText);
                break;
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
}
