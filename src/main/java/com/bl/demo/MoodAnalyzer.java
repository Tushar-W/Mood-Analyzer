package com.bl.demo;

public class MoodAnalyzer {
    public String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(){
        try {
            if (message.contains("I am in Sad mood"))
                return "SAD";
            else
                return "HAPPY";
        }catch(NullPointerException e) {
            return "HAPPY";
        }
    }
}
