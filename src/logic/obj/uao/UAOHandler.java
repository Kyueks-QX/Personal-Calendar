package logic.obj.uao;

import models.uao.UserActionObject;

import java.util.ArrayList;
import java.util.List;

/**
 * All classes which handle UAOs inherit this.
 */
public abstract class UAOHandler {
    //turn this into a set eventually
    /**
     * Contains all UAOs.
     */
    public static List<UserActionObject> userActionObjects = new ArrayList<>();
    /**
     * Holds the current UAO in use.
     */
    public static UserActionObject currentUAO;
    /**
     * Different arguments used when prompts call the relevant functions.
     */
    public static List<Object> menuArgs = new ArrayList<>();
}
