package models;

import java.util.HashMap;
import java.util.Map;

public class Menu implements UserInteractive {
    private String name;
    private String desc;
    private Map<UserInteractive, String> options;

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

    public Map<UserInteractive, String> getOptions() {
        return options;
    }

    public void setOptions(HashMap<UserInteractive, String> options) {
        this.options = options;
    }

    public static class Builder {
        private String name;
        private String desc;
        private HashMap<UserInteractive, String> options;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder withOptions(HashMap<UserInteractive, String> options) {
            this.options = options;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
