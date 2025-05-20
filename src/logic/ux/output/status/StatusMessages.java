package logic.ux.output.status;

import logic.obj.uao.UAONames;
import logic.ux.output.OutputHandler;

public class StatusMessages extends OutputHandler {
    public static void printStatus(UAONames actionName) {
        switch (actionName) {
            case ACTION_BOOK: StatusBook.bookStatus(); break;
            default: System.out.println("Action executed.\n");
        }
    }
}
