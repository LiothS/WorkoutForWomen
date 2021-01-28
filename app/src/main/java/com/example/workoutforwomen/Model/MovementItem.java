package com.example.workoutforwomen.Model;

import java.io.Serializable;

public class MovementItem implements Serializable {
    public String name, gif;
    public int id,duration;
    public int completeTime;

    public int getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int completeTime) {
        this.completeTime = completeTime;
    }

    public MovementItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MovementItem(String name, String gif, int id, int duration) {
        this.name = name;
        this.gif = gif;
        this.id = id;
        this.duration = duration;
    }
}
