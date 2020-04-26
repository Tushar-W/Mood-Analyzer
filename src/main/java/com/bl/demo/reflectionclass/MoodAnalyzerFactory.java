package com.bl.demo.reflectionclass;

import com.bl.demo.MoodAnalyzer;
import com.bl.demo.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(String classPath, Class<?> paramType, String message) throws MoodAnalysisException {
        Object moodObj=null;
        try {
            Class<?> moodAnalyzerClass = forName(classPath);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(paramType);
            moodObj = moodConstructor.newInstance(message);
        }
        catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.Exception_Type.WRONG_CLASS,"NO SUCH CLASS ERROR");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.Exception_Type.WRONG_METHOD,"NO SUCH METHOD ERROR");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  (MoodAnalyzer) moodObj;
    }

    public static String invokeMethod(MoodAnalyzer obj, String method) throws IllegalAccessException, InvocationTargetException {
        Method refMethod = null;
        try {
            refMethod = obj.getClass().getDeclaredMethod(method);
            return (String) refMethod.invoke(obj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.Exception_Type.WRONG_METHOD, "NO SUCH METHOD ERROR");
        }
    }
}