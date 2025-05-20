package logic.obj.uao;

import logic.obj.uao.action.ActionAdder;
import logic.obj.uao.menu.MenuAdder;
import logic.obj.uao.prompt.PromptAdder;

//contains every single UAO adder as public static fields
public class UAOAdders {
    public static MenuAdder menuAdder = new MenuAdder();
    public static PromptAdder promptAdder = new PromptAdder();
    public static ActionAdder actionAdder = new ActionAdder();
}