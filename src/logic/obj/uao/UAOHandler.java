package logic.obj.uao;

import models.uao.UserActionObject;

import java.util.ArrayList;
import java.util.List;

public abstract class UAOHandler {
    //turn this into a set eventually
    public static List<UserActionObject> userActionObjects = new ArrayList<>();
    public static UserActionObject currentUAO;
    public static List<Object> menuArgs = new ArrayList<>();
}
