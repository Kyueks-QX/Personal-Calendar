package logic.ux.input;

import logic.obj.calendar.CalendarAgenda;
import logic.obj.calendar.CalendarFind;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.ux.output.OutputList;
import logic.ux.output.OutputUAO;
import models.calendar.Day;
import models.uao.Prompt;
import models.uao.PromptChain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputFind extends InputHandler {
    public static Integer input(Void v) {
        UAOHandler.currentUAO = UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_FIND);
        OutputUAO.printUAO();
        inputText = scanner.nextLine();
        try {
            if (Integer.parseInt(inputText) == 0) { return -1; }
        } catch (Exception _) { }

        OutputList.printDateList(CalendarFind.find(inputText));

        return 0;
    }
}
