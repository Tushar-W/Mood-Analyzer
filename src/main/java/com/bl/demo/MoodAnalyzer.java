package com.bl.demo;

import com.bl.demo.exception.MoodAnalysisException;

public class MoodAnalyzer {
    public String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {
        try {
            if (message.contains("I am in Sad mood"))
                return "SAD";
            else
                return "HAPPY";
        }catch(NullPointerException e) {
            throw new MoodAnalysisException("Please Enter Proper Mood");
        }
    }
}
