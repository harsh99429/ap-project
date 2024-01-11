package com.example.demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class factory_test_runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(factory_test.class);

        if (result.wasSuccessful()) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println("Test failures:");

            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
}