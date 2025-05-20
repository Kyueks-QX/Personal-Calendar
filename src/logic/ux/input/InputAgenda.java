package logic.ux.input;

import logic.obj.calendar.CalendarAgenda;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.ux.output.OutputList;
import logic.ux.output.OutputUAO;
import models.calendar.Day;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputAgenda extends InputHandler {
    public static Integer input(Void v) {
        LocalDate localDate;

        UAOHandler.currentUAO = UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_AGENDA);
        OutputUAO.printUAO();
        inputText = scanner.nextLine();

        localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        OutputList.printDateList(CalendarAgenda.agenda(new Day(localDate)));

        return 0;
    }
}
