package com.bl.demo;

import com.bl.demo.exception.MoodAnalysisException;
import com.bl.demo.reflectionclass.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.bl.demo.reflectionclass.MoodAnalyzerFactory.createMoodAnalyzer;


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

    //Default Constructor
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,null);
        Assert.assertEquals(new MoodAnalyzer(),obj);
    }

    @Test
    public void givenMoodAnalyzerClass_WhenNotProper_ShouldReturnThrowException() {
        try {
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.Mood",String.class,null);
            Assert.assertEquals(new MoodAnalyzer(),obj);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH CLASS ERROR",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzerMethod_WhenNotProper_ShouldReturnThrowException()  {
        try {
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",Integer.class,null);
            Assert.assertEquals(new MoodAnalyzer(),obj);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH METHOD ERROR",e.getMessage());
        }

    }

    //Parameter Constructor
    @Test
    public void givenMoodAnalyzerClassConstructor_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"),obj);
    }

    @Test
    public void givenMoodAnalyzerClassConstructor_WhenNotProper_ShouldReturnThrowException() {
        try {
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.Mood",String.class,"I am in Happy mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"),obj);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH CLASS ERROR",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzerConstructorMethod_WhenNotProper_ShouldReturnThrowException()  {
        try {
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",Integer.class,"I am in Happy mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"),obj);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH METHOD ERROR",e.getMessage());
        }

    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() throws InvocationTargetException, IllegalAccessException {
        MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
        String mood = MoodAnalyzerFactory.invokeMethod(obj,"analyzeMood");
        Assert.assertEquals("HAPPY",mood);

    }

    @Test
    public void givenHappyMessage_WhenImProper_ShouldReturnThrowException() {
        try {
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
            String mood = MoodAnalyzerFactory.invokeMethod(obj,"analyzeMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH METHOD ERROR",e.getMessage());

        }
    }

    @Test
    public void givenFieldName_WhenProper_ShouldReturnMood() {
        MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
        String mood = MoodAnalyzerFactory.invokeMethod(obj,"analyzeMood");
        MoodAnalyzerFactory.fieldChangeDynamically(obj,"message","I am in Happy Mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenFieldName_WhenImProper_ShouldReturnMood() {
        try{
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
            String mood = MoodAnalyzerFactory.invokeMethod(obj,"analyzeMood");
            MoodAnalyzerFactory.fieldChangeDynamically(obj,"","I am in Happy Mood");
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalysisException e) {
            Assert.assertEquals("NO SUCH FIELD ERROR",e.getMessage());
        }

    }

    @Test
    public void givenFieldMessage_WhenMessageIsNull_ShouldReturnThrowException() {
        try{
            MoodAnalyzer obj = createMoodAnalyzer("com.bl.demo.MoodAnalyzer",String.class,"I am in Happy mood");
            String mood = MoodAnalyzerFactory.invokeMethod(obj,"analyzeMood");
            MoodAnalyzerFactory.fieldChangeDynamically(obj,"message",null);
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalysisException e) {
            Assert.assertEquals("MESSAGE IS NULL",e.getMessage());
        }

    }
}