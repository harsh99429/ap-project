package com.example.demo;

//public class singleton_junit_runner {
//
//}
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class singleton_junit_runner {
    public static void main(String[] args) {
        Result result=
                JUnitCore.runClasses(singleton_test.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}