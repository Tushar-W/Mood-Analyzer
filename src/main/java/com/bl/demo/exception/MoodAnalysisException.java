package com.bl.demo.exception;

public class MoodAnalysisException extends RuntimeException {
    public enum Exception_Type {
        ENTERED_NULL,ENTERED_EMPTY,WRONG_CLASS,WRONG_METHOD,WRONG_FIELD;
    }

    public MoodAnalysisException(Exception_Type type,String message) {
        super(message);
    }
}
