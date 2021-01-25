package com.example.workoutforwomen.Model;

public class DayItem {
    private String dayString, dayNumber;
    private boolean isActive;

    public DayItem(String dayString, String dayNumber, boolean isActive) {
        this.dayString = dayString;
        this.dayNumber = dayNumber;
        this.isActive = isActive;
    }

    public String getDayString() {
        return dayString;
    }

    public void setDayString(String dayString) {
        this.dayString = dayString;
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(String dayNumber) {
        this.dayNumber = dayNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
