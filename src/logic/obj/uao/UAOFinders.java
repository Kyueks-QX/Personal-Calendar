package logic.obj.uao;

import logic.obj.uao.action.ActionFinder;
import logic.obj.uao.menu.MenuFinder;
import logic.obj.uao.prompt.PromptFinder;

public class UAOFinders {
    public static MenuFinder menuFinder = new MenuFinder();
    public static PromptFinder promptFinder = new PromptFinder();
    public static ActionFinder actionFinder = new ActionFinder();
}
