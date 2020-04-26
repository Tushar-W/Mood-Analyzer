package com.bl.demo;

import com.bl.demo.exception.MoodAnalysisException;
import com.bl.demo.reflectionclass.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Class.forName;

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

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer obj = MoodAnalyzerFactory.createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"),obj);
    }

    @Test
    public void givenMoodAnalyzerClass_WhenNotProper_ShouldReturnThrowException() {
        try {
            MoodAnalyzer obj = MoodAnalyzerFactory.createMoodAnalyzer("com.bl.demo.Mood",String.class,"I am in Happy mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"),obj);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH CLASS",e.getMessage());
        }
    }
}
