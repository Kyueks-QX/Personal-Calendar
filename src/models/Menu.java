package models;

import java.util.List;

public class Menu {
    private String name;
    private String desc;
    private List<String> options;

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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public static class Builder {
        private String name;
        private String desc;
        private List<String> options;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder withOptions(List<String> options) {
            this.options = options;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
