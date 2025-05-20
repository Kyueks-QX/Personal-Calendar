package models.uao;

import logic.obj.uao.UAONames;

public class Prompt implements UserActionObject {
    private UAONames name;
    private String inputField;
    private String instruction;
    private String format;
    private String input;

    private Prompt() { }

    private Prompt(Builder builder) {
        this.name = builder.name;
        this.inputField = builder.inputField;
        this.instruction = builder.instruction;
        this.format = builder.format;
        this.input = builder.input;
    }

    public UAONames getName() {
        return name;
    }

    public void setName(UAONames name) {
        this.name = name;
    }

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String inputField) {
        this.inputField = inputField;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public static class Builder {
        private UAONames name;
        private String inputField;
        private String instruction;
        private String format;
        private String input;

        public Builder withName(UAONames name) {
            this.name = name;
            return this;
        }

        public Builder withInputField(String inputField) {
            this.inputField = inputField;
            return this;
        }

        public Builder withInstruction(String instruction) {
            this.instruction = instruction;
            return this;
        }

        public Builder withFormat(String format) {
            this.format = format;
            return this;
        }

        public Builder withInput(String input) {
            this.input = input;
            return this;
        }

        public Prompt build() {
            return new Prompt(this);
        }
    }
}
