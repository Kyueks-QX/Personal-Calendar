package models;

import java.time.LocalTime;

// A date, synonymous to meeting, not time. The date still has time, though.
public class Date {
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String note;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private Date() {}

    private Date(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.name = builder.name;
        this.note = builder.note;
    }

    //I don't think a builder is necessary, but for the sake of scalability, here it is.
    public static class Builder {
        private LocalTime startTime;
        private LocalTime endTime;
        private String name;
        private String note;

        public Builder() {}

        public Builder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withNote(String note) {
            this.note = note;
            return this;
        }

        public Date build() {
            return new Date(this);
        }
    }
}
