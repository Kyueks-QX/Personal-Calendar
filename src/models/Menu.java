package models;

import java.util.HashMap;
import java.util.Map;

public class Menu implements UserActionObject {
    private String name;
    private String desc;
    private Map<UserActionObject, String> options;
    private UserActionObject prevUserActionObject;

    @Override
    public UserActionObject getActionObject() {
        return this;
    }

    private Menu(Builder builder) {
        this.name = builder.name;
        this.desc = builder.desc;
        this.options = builder.options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap<UserActionObject, String> getOptions() {
        return (HashMap<UserActionObject, String>) options;
    }

    public void setOptions(HashMap<UserActionObject, String> options) {
        this.options = options;
    }

    public UserActionObject getPrevAction() {
        return prevUserActionObject;
    }

    public void setPrevAction(UserActionObject prevUserActionObject) {
        this.prevUserActionObject = prevUserActionObject;
    }

    public static class Builder {
        private String name;
        private String desc;
        private HashMap<UserActionObject, String> options;
        private UserActionObject prevUserActionObject;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder withOptions(HashMap<UserActionObject, String> options) {
            this.options = options;
            return this;
        }

        public Builder withPrevAction(UserActionObject prevUserActionObject) {
            this.prevUserActionObject = prevUserActionObject;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
