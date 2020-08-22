package com.thebigcourses.myfirstquizapp;

public class Question {
    private int resID;
    private boolean isTrue;

    public Question(int resID, boolean isTrue) {
        this.resID = resID;
        this.isTrue = isTrue;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
