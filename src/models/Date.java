package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

// A date, synonymous to meeting, not time. The date still has time, though.
public class Date {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String note;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

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
        this.day = builder.day;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.name = builder.name;
        this.note = builder.note;
    }

    //I don't think a builder is necessary, but for the sake of scalability, here it is.
    public static class Builder {
        private LocalDate day;
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

        public Builder withDay(LocalDate day) {
            this.day = day;
            return this;
        }

        public Date build() {
            return new Date(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(getDay(), date.getDay()) && Objects.equals(getStartTime(), date.getStartTime()) && Objects.equals(getEndTime(), date.getEndTime()) && Objects.equals(getName(), date.getName()) && Objects.equals(getNote(), date.getNote());
    }

    //it's like equals except it allows the compared object to have null fields
    public boolean equivalent(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return (Objects.equals(getDay(), date.getDay()) || date.getDay() == null)
                && (Objects.equals(getStartTime(), date.getStartTime()) || date.getStartTime() == null)
                && (Objects.equals(getEndTime(), date.getEndTime()) || date.getEndTime() == null)
                && (Objects.equals(getName(), date.getName()) || date.getName() == null)
                && (Objects.equals(getNote(), date.getNote()) || date.getNote() == null);
    }
}
