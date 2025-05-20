package models.uao;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;

import java.util.List;

public class PromptChain extends UAOHandler implements UserActionObject {
    private UAONames name;
    public List<Prompt> promptChain;

    public UAONames getName() {
        return name;
    }

    public void setName(UAONames name) {
        this.name = name;
    }

    public List<Prompt> getPromptChain() {
        return promptChain;
    }

    public void setPromptChain(List<Prompt> promptChain) {
        this.promptChain = promptChain;
    }
}
