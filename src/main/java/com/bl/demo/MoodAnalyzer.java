package com.bl.demo;

public class MoodAnalyzer {
    public String analyzeMood(String message){
        if (message.contains("I am in Sad mood"))
            return "SAD";
        else
            return "HAPPY";
    }
}
