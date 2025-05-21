package logic.ux.input;

import logic.obj.calendar.CalendarAgenda;
import logic.obj.calendar.CalendarHoliday;
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

public class InputHoliday extends InputHandler {
    public static Integer input(Void v) {
        LocalDate localDate;

        UAOHandler.currentUAO = UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_HOLIDAY);
        OutputUAO.printUAO();
        inputText = scanner.nextLine();
        try {
            if (Integer.parseInt(inputText) == 0) { return -1; }
        } catch (Exception _) { }

        try {
            localDate = LocalDate.parse(inputText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            System.out.println("Parsing Error!: " + e);
            return -2;
        }

        return CalendarHoliday.holiday(new Day(localDate));
    }
}
