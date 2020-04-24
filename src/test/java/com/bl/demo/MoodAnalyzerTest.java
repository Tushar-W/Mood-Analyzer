package com.bl.demo;

import com.bl.demo.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;

    @Test
    public void givenMood_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMood_WhenAnyMood_ShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in Any mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMood_WhenSadPassThroughConstructor_ShouldReturnSad() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Sad mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMood_WhenHappyPassThroughConstructor_ShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am in Happy mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMood_WhenIsNull_ShouldReturnThrowException() {
        moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Mood Is Null",e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenIsEmpty_ShouldReturnThrowException() {
        moodAnalyzer = new MoodAnalyzer("");
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Mood Is Empty",e.getMessage());
        }
    }
}