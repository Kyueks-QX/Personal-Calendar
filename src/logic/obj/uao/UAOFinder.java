package logic.obj.uao;

import logic.find.Finder;
import models.uao.UserActionObject;

/**
 * Finders for UAO objects.
 */
public interface UAOFinder extends Finder {
    /**
     * Locate a UAO by its name.
     * @param name
     * Comes from an enum of UAO names.
     * @return
     * The UAO itself if it exists.
     */
    UserActionObject findUAOByName(UAONames name);
}
