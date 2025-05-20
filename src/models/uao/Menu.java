package models.uao;

import logic.obj.uao.UAONames;

import java.util.HashMap;
import java.util.Map;

public class Menu implements UserActionObject {
    private UAONames name;
    private String desc;
    private Map<UAONames, String> options;

    private Menu(Builder builder) {
        this.name = builder.name;
        this.desc = builder.desc;
        this.options = builder.options;
    }

    public UAONames getName() {
        return name;
    }

    public void setName(UAONames name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<UAONames, String> getOptions() {
        return options;
    }

    public void setOptions(Map<UAONames, String> options) {
        this.options = options;
    }

    public static class Builder {
        private UAONames name;
        private String desc;
        private Map<UAONames, String> options;

        public Builder withName(UAONames name) {
            this.name = name;
            return this;
        }

        public Builder withDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder withOptions(HashMap<UAONames, String> options) {
            this.options = options;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
