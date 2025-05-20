package logic.ux.input;

import logic.obj.uao.UAOHandler;
import logic.ux.output.OutputUAO;
import models.uao.Prompt;
import models.uao.PromptChain;

public class InputHoliday extends InputHandler {
    public static Integer input(Void v) {
        PromptChain promptChain = new PromptChain();

        for (Prompt prompt : promptChain.getPromptChain()) {
            UAOHandler.currentUAO = prompt;
            OutputUAO.printUAO();
            inputText = scanner.nextLine();

            switch (prompt.getName()) {
            
            }
        }

        return 0;
    }
}
