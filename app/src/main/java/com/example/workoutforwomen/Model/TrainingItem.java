package com.example.workoutforwomen.Model;

public class TrainingItem {
    public String  Name, Time,level,image;
    public int isSaved,duration;

    public TrainingItem() {
    }
    public  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainingItem(int id, String name, String level, String image, int isSaved, int duration) {
        this.id = id;
        Name = name;
        this.level = level;
        this.image = image;
        this.isSaved = isSaved;
        this.duration = duration;
    }

    public TrainingItem(int id) {
        this.id = id;
    }

    public TrainingItem(String name, String level, String image, int isSaved, int duration) {
        Name = name;
        this.level = level;
        this.image = image;
        this.isSaved = isSaved;
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(int isSaved) {
        this.isSaved = isSaved;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public TrainingItem(String name, String time) {
        Name = name;
        Time = time;
    }
}
