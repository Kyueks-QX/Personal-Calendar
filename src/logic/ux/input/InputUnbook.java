package logic.ux.input;

import logic.obj.calendar.CalendarMerge;
import logic.obj.calendar.CalendarUnbook;
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

public class InputUnbook extends InputHandler {
    public static Integer input(Void v) {
        UAOHandler.menuArgs.clear();
        LocalDate localDate;

        PromptChain promptChain = new PromptChain();
        promptChain.setPromptChain(PromptChainMaker.makePromptChain(
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_UNBOOK),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_STARTTIME),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BOOK_ENDTIME)
        ));

        for (Prompt prompt : promptChain.getPromptChain()) {
            UAOHandler.currentUAO = prompt;
            OutputUAO.printUAO();
            inputText = scanner.nextLine();
            try {
                if (Integer.parseInt(inputText) == 0) { return -1; }
            } catch (Exception _) { }

            try {
                switch (prompt.getName()) {
                    case PROMPT_UNBOOK: {
                        localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        UAOHandler.menuArgs.add(new Day(localDate));
                        break;
                    }
                    case PROMPT_BOOK_STARTTIME, PROMPT_BOOK_ENDTIME: {
                        UAOHandler.menuArgs.add(LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Parsing Error!: " + e);
                return -2;
            }
        }

        return CalendarUnbook.unbook(
                (Day) UAOHandler.menuArgs.get(0),
                (LocalTime) UAOHandler.menuArgs.get(1),
                (LocalTime) UAOHandler.menuArgs.get(2)
        );
    }
}
