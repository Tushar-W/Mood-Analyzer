package com.bl.demo;

import com.bl.demo.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMood_WhenSad_ShouldReturnBSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMood_WhenHappy_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMood_WhenNull_ShouldReturnThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Mood Is Null",e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenIsEmpty_ShouldReturn() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Mood Is Empty",e.getMessage());
        }
    }
}
