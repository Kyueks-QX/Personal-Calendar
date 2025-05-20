package logic.obj.uao;

import logic.find.Finder;
import models.uao.UserActionObject;

public interface UAOFinder extends Finder {
    UserActionObject findUAOByName(UAONames name);
}
