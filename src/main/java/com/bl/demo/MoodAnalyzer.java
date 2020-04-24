package com.bl.demo;

public class MoodAnalyzer {
    public String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String  message) {
        try {
            if (message.contains("I am in Sad mood"))
                return "SAD";
            else
                return "HAPPY";
        }catch(NullPointerException e){
            return "HAPPY";
        }
    }

    public String analyzeMood() {
        return this.analyzeMood(message);
    }
}
