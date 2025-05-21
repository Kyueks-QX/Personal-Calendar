package logic.ux.input;

import logic.obj.calendar.CalendarFindSlot;
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
import java.util.ArrayList;

public class InputFindSlot extends InputHandler {
    public static Integer input(Void v) {
        UAOHandler.menuArgs.clear();
        LocalDate localDate;

        PromptChain promptChain = new PromptChain();
        promptChain.setPromptChain(PromptChainMaker.makePromptChain(
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_FINDSLOT_FROMDAY),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_FINDSLOT_HOURS),
                (Prompt) UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_FINDSLOT_FILENAME)
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
                    case PROMPT_FINDSLOT_FROMDAY: {
                        localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        UAOHandler.menuArgs.add(new Day(localDate));
                        break;
                    }
                    case PROMPT_FINDSLOT_HOURS: {
                        UAOHandler.menuArgs.add(Integer.parseInt(inputText));
                        break;
                    }
                    case PROMPT_FINDSLOT_FILENAME: {
                        if (inputText.equals("*")) {
                            UAOHandler.menuArgs.add(null);
                        } else {
                            UAOHandler.menuArgs.add(inputText + ".txt");
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Parsing Error!: " + e);
                return -2;
            }
        }

        Date date = CalendarFindSlot.findSlot(
                (Day) UAOHandler.menuArgs.get(0),
                (Integer) UAOHandler.menuArgs.get(1),
                (String) UAOHandler.menuArgs.get(2)
        );

        if (date == null) { return 1; }
        return 0;
    }
}
