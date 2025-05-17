package models;

public class Prompt implements UserActionObject {
    private String name;
    private String inputField;
    private String instruction;
    private String format;
    //not sure about the input field
    private String input;

    @Override
    public UserActionObject getActionObject() {
        return this;
    }

    public Prompt() { }

    public Prompt(String name, String inputField, String instruction, String format) {
        this.name = name;
        this.inputField = inputField;
        this.instruction = instruction;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}
