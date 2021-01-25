package com.example.workoutforwomen.Model;

public class BeginerPlanItem {
    private  String planName, planTime;

    public BeginerPlanItem(String planName, String planTime) {
        this.planName = planName;
        this.planTime = planTime;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public BeginerPlanItem(String planName) {
        this.planName = planName;
    }
}
