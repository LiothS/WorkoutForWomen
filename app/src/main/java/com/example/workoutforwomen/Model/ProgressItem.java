package com.example.workoutforwomen.Model;

public class ProgressItem {
    private int Value;
    private String name;

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgressItem(int value, String name) {
        Value = value;
        this.name = name;
    }
}
