package com.bl.demo.reflectionclass;

import com.bl.demo.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String classPath, Class<?> paramType, String message) {
        Object moodObj=null;
        try {
            Class<?> moodAnalyzerClass = forName(classPath);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(paramType);
            moodObj = moodConstructor.newInstance(message);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  (MoodAnalyzer) moodObj;
    }
}