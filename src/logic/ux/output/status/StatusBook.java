package logic.ux.output.status;

import logic.ux.output.OutputHandler;
import logic.ux.output.OutputUAO;

public class StatusBook extends OutputHandler {
    public static void bookStatus() {
        switch (status) {
            case 0: {
                message = "Date successfully booked.";
                break;
            }
            case 1: {
                message = "ERROR: One (or more) argument(s) were null.";
                break;
            }
            case 2: {
                message = "ERROR: Can't book on a holiday.";
                break;
            }
            case 3: {
                message = "ERROR: Date conflicts with another on the same day.";
                break;
            }
            case 4: {
                message = "ERROR: Date's start time is after its end time.";
                break;
            }
        }

        System.out.println(message + "\n");
    }
}
