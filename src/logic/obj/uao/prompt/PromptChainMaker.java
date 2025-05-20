package logic.obj.uao.prompt;

import models.uao.Action;
import models.uao.Prompt;
import models.uao.UserActionObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromptChainMaker {
    public static List<Prompt> makePromptChain(Prompt... prompts) {
        return new ArrayList<>(Arrays.asList(prompts));
    }
}
