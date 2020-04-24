package com.bl.demo;

public class MoodAnalyzer {
    public String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String  message){
        if (message.contains("I am in Sad mood"))
            return "SAD";
        else
            return "HAPPY";
    }

    public String analyzeMood() {
        return this.analyzeMood(message);
    }
}
