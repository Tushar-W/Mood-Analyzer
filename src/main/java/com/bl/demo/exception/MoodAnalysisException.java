package com.bl.demo.exception;

public class MoodAnalysisException extends Exception {
    public enum Exception_Type {
        ENTERED_NULL,ENTERED_EMPTY,WRONG_CLASS,WRONG_METHOD;
    }

    public MoodAnalysisException(Exception_Type type,String message) {
        super(message);
    }
}
