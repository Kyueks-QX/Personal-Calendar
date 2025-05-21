package logic.ux.input;

import logic.obj.calendar.CalendarBook;
import logic.obj.calendar.CalendarChange;
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
        UAOHandler.menuArgs.clear();
        int index;
        DateFieldNames dateFieldName = null;
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
            try {
                if (Integer.parseInt(inputText) == 0) { return -1; }
            } catch (Exception _) { }

            try {
                switch (prompt.getName()) {
                    case PROMPT_CHANGE_DAY: {
                        localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        UAOHandler.menuArgs.add(new Day(localDate));
                        break;
                    }
                    case PROMPT_CHANGE_STARTTIME: {
                        UAOHandler.menuArgs.add(LocalTime.parse(inputText, DateTimeFormatter.ofPattern("HH:mm")));
                        break;
                    }
                    case PROMPT_CHANGE_DATEFIELD: {
                        index = Integer.parseInt(inputText) - 1;
                        if (index >= 5) { return 5; }
                        dateFieldName = DateFieldNames.values()[index];
                        UAOHandler.menuArgs.add(dateFieldName);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Parsing Error!: " + e);
                return -2;
            }
        }

        if (dateFieldName == null) { return 5; }

        Prompt prompt = (Prompt) UAOFinders.promptFinder.findUAOByName(
                UAONames.valueOf("PROMPT_BOOK_" + dateFieldName)
        );
        InputBook.inputBook(prompt);

        return CalendarChange.change(
                (Day) UAOHandler.menuArgs.get(0),
                (LocalTime) UAOHandler.menuArgs.get(1),
                (DateFieldNames) UAOHandler.menuArgs.get(2),
                (String) UAOHandler.menuArgs.get(3)
        );
    }
}
