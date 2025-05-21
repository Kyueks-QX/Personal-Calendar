package logic.obj.uao;

import logic.obj.uao.action.ActionAdder;
import logic.obj.uao.menu.MenuAdder;
import logic.obj.uao.prompt.PromptAdder;

/**
 * Contains every single UAO adder as public static fields.
 */
public class UAOAdders {
    /**
     * Publicly available menu adder.
     */
    public static MenuAdder menuAdder = new MenuAdder();
    /**
     * Publicly available prompt adder.
     */
    public static PromptAdder promptAdder = new PromptAdder();
    /**
     * Publicly available action adder.
     */
    public static ActionAdder actionAdder = new ActionAdder();
}