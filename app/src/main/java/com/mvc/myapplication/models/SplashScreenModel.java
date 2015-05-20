package com.mvc.myapplication.models;

/**
 * Created by rex.yau on 4/15/2015.
 */
public class SplashScreenModel {
    boolean isFirstStart;
    int delay;

    public SplashScreenModel() {

    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setFirstStart(boolean isFirstStart) {
        this.isFirstStart = isFirstStart;
    }

    public boolean isFirstStart() {
        return isFirstStart;
    }
}
