package logic.obj.uao.prompt;

import logic.obj.uao.UAONames;
import models.uao.Prompt;

public class PromptMaker {
    public static Prompt makePrompt(UAONames name, String inputField, String instruction, String format) {
        return new Prompt.Builder()
                .withName(name)
                .withInputField(inputField)
                .withInstruction(instruction)
                .withFormat(format)
                .withInput(null)
                .build();
    }
}
