package logic.ux.input;

import logic.file.FileHandler;
import logic.file.FileLoader;
import logic.file.FileName;
import logic.file.FileSaver;
import logic.obj.calendar.CalendarHandler;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.ux.output.OutputUAO;

public class InputFile extends InputHandler {
    public static Integer input(Void v) {
        UAOHandler.currentUAO = UAOFinders.promptFinder.findUAOByName(UAONames.PROMPT_SAVE_CHANGE);
        OutputUAO.printUAO();
        inputText = scanner.nextLine();
        try {
            if (Integer.parseInt(inputText) == 0) { return -1; }
        } catch (Exception _) { }

        return FileName.setFileName(inputText + ".txt");
    }

    public static Integer save(Void v) {
        FileSaver.saveCalendarToFile(CalendarHandler.calendar);
        return 0;
    }

    public static Integer load(Void v) {
        CalendarHandler.calendar = FileLoader.loadCalendarFromFile(logic.file.FileHandler.fileName);
        return 0;
    }

    public static Integer current(Void v) {
        System.out.println(FileHandler.fileName);
        return 0;
    }
}
