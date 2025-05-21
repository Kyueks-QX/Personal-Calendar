package logic.obj.uao;

import logic.obj.uao.action.ActionFinder;
import logic.obj.uao.menu.MenuFinder;
import logic.obj.uao.prompt.PromptFinder;

public class UAOFinders {
    /**
     * Publicly available menu finder.
     */
    public static MenuFinder menuFinder = new MenuFinder();
    /**
     * Publicly available prompt finder.
     */
    public static PromptFinder promptFinder = new PromptFinder();
    /**
     * Publicly available action finder.
     */
    public static ActionFinder actionFinder = new ActionFinder();
}
