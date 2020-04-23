package com.bl.demo;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMood_WhenBad_ShouldReturnBad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMood_WhenHappy_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("I am in Any mood");
        Assert.assertEquals("HAPPY",mood);
    }

}
