package models.uao;

import logic.obj.uao.UAONames;

import java.util.function.Function;

public class Action implements UserActionObject {
    private UAONames name;
    private Function<Void, Integer> function;

    private Action() { }

    private Action(Builder builder) {
        this.name = builder.name;
        this.function = builder.function;
    }

    public UAONames getName() {
        return name;
    }

    public void setName(UAONames name) {
        this.name = name;
    }

    public Function<Void, Integer> getFunction() {
        return function;
    }

    public void setFunction(Function<Void, Integer> function) {
        this.function = function;
    }

    public static class Builder {
        private UAONames name;
        private Function<Void, Integer> function;

        public Builder withName(UAONames name) {
            this.name = name;
            return this;
        }

        public Builder withFunction(Function<Void, Integer> function) {
            this.function = function;
            return this;
        }

        public Action build() {
            return new Action(this);
        }
    }
}
