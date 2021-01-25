package com.example.workoutforwomen.Model;

public class ChallengeItem {
    private String challengeName, challengeLv, challengeMessage;

    public String getChallengeName() {
        return challengeName;
    }

    public String getChallengeMessage() {
        return challengeMessage;
    }

    public void setChallengeMessage(String challengeMessage) {
        this.challengeMessage = challengeMessage;
    }

    public ChallengeItem(String challengeName, String challengeLv, String challengeMessage) {
        this.challengeName = challengeName;
        this.challengeLv = challengeLv;
        this.challengeMessage = challengeMessage;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getChallengeLv() {
        return challengeLv;
    }

    public void setChallengeLv(String challengeLv) {
        this.challengeLv = challengeLv;
    }

    public ChallengeItem(String challengeName, String challengeLv) {
        this.challengeName = challengeName;
        this.challengeLv = challengeLv;
    }
}
