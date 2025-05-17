package logic.obj.uao;

import models.UserActionObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class UAOHandler {
    //turn this into a set eventually
    public static List<UserActionObject> userActionObjects = new ArrayList<>();
    public static Stack<UserActionObject> UAOStack = new Stack<>();
    public static List<Object> menuArgs = new ArrayList<>();
}
