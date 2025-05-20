package logic.ux.input;

import logic.obj.calendar.CalendarBusyDays;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.prompt.PromptChainMaker;
import logic.ux.output.OutputList;
import logic.ux.output.OutputUAO;
import models.calendar.Date;
import models.calendar.Day;
import models.uao.Prompt;
import models.uao.PromptChain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputBusyDays extends InputHandler {
    public static Integer input(Void v) {
        LocalDate localDate;

        PromptChain promptChain = new PromptChain();
        promptChain.setPromptChain(PromptChainMaker.makePromptChain(
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BUSYDAYS_FROM),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_BUSYDAYS_TO)
        ));

        for (Prompt prompt : promptChain.getPromptChain()) {
            UAOHandler.currentUAO = prompt;
            OutputUAO.printUAO();
            inputText = scanner.nextLine();

            switch (prompt.getName()) {
                case PROMPT_BUSYDAYS_FROM: {
                    localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    UAOHandler.menuArgs.set(0, new Day(localDate));
                    break;
                }
                case PROMPT_BUSYDAYS_TO: {
                    localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    UAOHandler.menuArgs.set(1, new Day(localDate));
                    break;
                }
            }
        }

        OutputList.printMapIntDay(CalendarBusyDays.busyDays(
                (Day) UAOHandler.menuArgs.get(0),
                (Day) UAOHandler.menuArgs.get(1)
        ));

        return 0;
    }
}
