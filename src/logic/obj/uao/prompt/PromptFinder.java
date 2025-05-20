package logic.obj.uao.prompt;

import logic.obj.uao.UAOFinder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Prompt;
import models.uao.UserActionObject;

public class PromptFinder extends UAOHandler implements UAOFinder {
    @Override
    public Object find(Object o) {
        Prompt searchedMenu = (Prompt) o;
        for (UserActionObject prompt : userActionObjects) {
            if (prompt.equals(searchedMenu)) {
                return userActionObjects.get(userActionObjects.indexOf(prompt));
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Prompt searchedMenu = (Prompt) o;
        for (UserActionObject prompt : userActionObjects) {
            if (prompt.equals(searchedMenu)) {
                return userActionObjects.indexOf(prompt);
            }
        }
        return -1;
    }

    @Override
    public UserActionObject findUAOByName(UAONames name) {
        for (UserActionObject prompt : userActionObjects) {
            if (!prompt.getClass().equals(Prompt.class)) {
                continue;
            }
            Prompt tempPrompt = (Prompt) prompt;
            if (tempPrompt.getName().equals(name)) {
                return tempPrompt;
            }
        }
        return null;
    }
}
